// GridFSInputFile.java

/**
 *      Copyright (C) 2008 10gen Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.mongodb.gridfs;

import java.io.*;
import java.security.*;
import java.util.*;

import org.bson.types.*;

import com.mongodb.*;
import com.mongodb.util.*;

/**
 * This class represents a GridFS file to be written to the database
 * Operations include:
 * - writing data obtained from an InputStream
 * - getting an OutputStream to stream the data out
 * 
 * @author Eliot Horowitz and Guy K. Kloss
 */
public class GridFSInputFile extends GridFSFile {
    
    /**
     * Default constructor setting the GridFS file name and providing an input
     * stream containing data to be written to the file.
     * 
     * @param fs
     *            The GridFS connection handle.
     * @param in
     *            Stream used for reading data from.
     * @param filename
     *            Name of the file to be created.
     */
    GridFSInputFile( GridFS fs , InputStream in , String filename ) {
        _fs = fs;
        _in = in;
        _filename = filename;
        
        _id = new ObjectId();
        _chunkSize = GridFS.DEFAULT_CHUNKSIZE;
        _uploadDate = new Date();
        _messageDigester = _md5Pool.get();
        _messageDigester.reset();
        _buffer = new byte[(int) _chunkSize];
    }
    
    /**
     * Constructor that only provides a file name, but does not rely on the
     * presence of an {@link java.io.InputStream}. An
     * {@link java.io.OutputStream} can later be obtained for writing using the
     * {@link #getOutputStream()} method.
     * 
     * @param fs
     *            The GridFS connection handle.
     * @param filename
     *            Name of the file to be created.
     */
    GridFSInputFile( GridFS fs , String filename ) {
        this( fs , null , filename );
    }
    
    /**
     * Minimal constructor that does not rely on the presence of an
     * {@link java.io.InputStream}. An {@link java.io.OutputStream} can later be
     * obtained for writing using the {@link #getOutputStream()} method.
     * 
     * @param fs
     *            The GridFS connection handle.
     */
    GridFSInputFile( GridFS fs ) {
        this( fs , null , null );
    }
    
    /**
     * Sets the file name on the GridFS entry.
     * 
     * @param fn
     *            File name.
     */
    public void setFilename( String fn ) {
        _filename = fn;
    }
    
    /**
     * Sets the content type (MIME type) on the GridFS entry.
     * 
     * @param ct
     *            Content type.
     */
    public void setContentType( String ct ) {
        _contentType = ct;
    }

    /**
     * Set the chunk size. This must be called before saving any data.
     * @param _chunkSize
     */
    public void setChunkSize(long _chunkSize) {
        if (_outputStream != null || _savedChunks)
            return;
        this._chunkSize = _chunkSize;
    }

    /**
     * calls {@link GridFSInputFile#save(long)} with the existing chunk size
     */
    @Override
    public void save() {
        save( _chunkSize);
    }
    
    /**
     * This method first calls saveChunks(long) if the file data has not been saved yet.
     * Then it persists the file entry to GridFS.
     * 
     * @param chunkSize
     *            Size of chunks for file in bytes.
     */
    public void save( long chunkSize ) {
        if (_outputStream != null)
            throw new MongoException( "cannot mix OutputStream and regular save()" );

        // note that chunkSize only changes _chunkSize in case we actually save chunks
        // otherwise there is a risk file and chunks are not compatible
        if ( ! _savedChunks ) {
            try {
                saveChunks( chunkSize );
            } catch ( IOException ioe ) {
                throw new MongoException( "couldn't save chunks" , ioe );
            }
        }
        
        super.save();
    }
    
    /**
     * @see com.mongodb.gridfs.GridFSInputFile#saveChunks(long)
     * 
     * @return Number of the next chunk.
     * @throws IOException
     *             on problems reading the new entry's
     *             {@link java.io.InputStream}.
     */
    public int saveChunks() throws IOException {
        return saveChunks( _chunkSize );
    }
    
    /**
     * Saves all data into chunks from configured {@link java.io.InputStream} input stream
     * to GridFS. A non-default chunk size can be specified.
     * This method does NOT save the file object itself, one must call save() to do so.
     * 
     * @param chunkSize
     *            Size of chunks for file in bytes.
     * @return Number of the next chunk.
     * @throws IOException
     *             on problems reading the new entry's
     *             {@link java.io.InputStream}.
     */
    public int saveChunks( long chunkSize ) throws IOException {
        if (_outputStream != null)
            throw new MongoException( "cannot mix OutputStream and regular save()" );
        if ( _savedChunks )
            throw new MongoException( "chunks already saved!" );

        if ( _chunkSize != chunkSize ) {
            _chunkSize = chunkSize;
            _buffer = new byte[(int) _chunkSize];
        }
        
        if ( chunkSize > 3.5 * 1000 * 1000 ) {
            throw new MongoException( "chunkSize must be less than 3.5MiB!" );
        }
        
        int bytesRead = 0;
        while ( bytesRead >= 0 ) {
            _currentBufferPosition = 0;
            bytesRead = _readStream2Buffer();
            _dumpBuffer( true );
        }

        // only finish data, do not write file, in case one wants to change metadata
        _finishData();
        return _currentChunkNumber;
    }
    
    /**
     * After retrieving this {@link java.io.OutputStream}, this object will be
     * capable of accepting successively written data to the output stream.
     * To completely persist this GridFS object, you must finally call the {@link java.io.OutputStream#close()}
     * method on the output stream. Note that calling the save() and saveChunks()
     * methods will throw Exceptions once you obtained the OutputStream.
     * 
     * @return Writable stream object.
     */
    public OutputStream getOutputStream() {
        if ( _outputStream == null ) {
            _outputStream = new MyOutputStream();
        }
        return _outputStream;
    }
    
    /**
     * Dumps a new chunk into the chunks collection. Depending on the flag, also
     * partial buffers (at the end) are going to be written immediately.
     * 
     * @param data
     *            Data for chunk.
     * @param writePartial
     *            Write also partial buffers full.
     */
    private void _dumpBuffer( boolean writePartial ) {
        if ( ( _currentBufferPosition < _chunkSize ) && !writePartial ) {
            // Bail out, chunk not complete yet
            return;
        }
        if (_currentBufferPosition == 0) {
            // chunk is empty, may be last chunk
            return;
        }

        byte[] writeBuffer = _buffer;
        if ( _currentBufferPosition != _chunkSize ) {
            writeBuffer = new byte[_currentBufferPosition];
            System.arraycopy( _buffer, 0, writeBuffer, 0, _currentBufferPosition );
        }
        
        DBObject chunk = BasicDBObjectBuilder.start()
                .add( "files_id", _id )
                .add( "n", _currentChunkNumber )
                .add( "data", writeBuffer ).get();
        _fs._chunkCollection.save( chunk );
        _currentChunkNumber++;
        _totalBytes += writeBuffer.length;
        _messageDigester.update( writeBuffer );
        _currentBufferPosition = 0;
    }
    
    /**
     * Reads a buffer full from the {@link java.io.InputStream}.
     * 
     * @return Number of bytes read from stream.
     * @throws IOException
     *             if the reading from the stream fails.
     */
    private int _readStream2Buffer() throws IOException {
        int bytesRead = 0;
        while ( _currentBufferPosition < _chunkSize && bytesRead >= 0 ) {
            bytesRead = _in.read( _buffer, _currentBufferPosition,
                                 (int) _chunkSize - _currentBufferPosition );
            if ( bytesRead > 0 ) {
                _currentBufferPosition += bytesRead;
            } else if ( bytesRead == 0 ) {
                throw new RuntimeException( "i'm doing something wrong" );
            }
        }
        return bytesRead;
    }
    
    /**
     * Marks the data as fully written. This needs to be called before super.save()
     */
    private void _finishData() {
        if (!_savedChunks) {
            _md5 = Util.toHex( _messageDigester.digest() );
            _md5Pool.done( _messageDigester );
            _messageDigester = null;
            _length = _totalBytes;
            _savedChunks = true;
        }
    }
    
    private final InputStream _in;
    private boolean _savedChunks = false;
    private byte[] _buffer = null;
    private int _currentChunkNumber = 0;
    private int _currentBufferPosition = 0;
    private long _totalBytes = 0;
    private MessageDigest _messageDigester = null;
    private OutputStream _outputStream = null;
    
    /**
     * A pool of {@link java.security.MessageDigest} objects.
     */
    static SimplePool<MessageDigest> _md5Pool
            = new SimplePool<MessageDigest>( "md5" , 10 , -1 , false , false ) {
        /**
         * {@inheritDoc}
         * 
         * @see com.mongodb.util.SimplePool#createNew()
         */
        protected MessageDigest createNew() {
            try {
                return MessageDigest.getInstance( "MD5" );
            } catch ( java.security.NoSuchAlgorithmException e ) {
                throw new RuntimeException( "your system doesn't have md5!" );
            }
        }
    };
    
    /**
     * An output stream implementation that can be used to successively write to
     * a GridFS file.
     * 
     * @author Guy K. Kloss
     */
    class MyOutputStream extends OutputStream {
        
        /**
         * {@inheritDoc}
         * 
         * @see java.io.OutputStream#write(int)
         */
        @Override
        public void write( int b ) throws IOException {
            byte[] byteArray = new byte[1];
            byteArray[0] = (byte) (b & 0xff);
            write( byteArray, 0, 1 );
        }
        
        /**
         * {@inheritDoc}
         * 
         * @see java.io.OutputStream#write(byte[], int, int)
         */
        @Override
        public void write( byte[] b , int off , int len ) throws IOException {
            int offset = off;
            int length = len;
            int toCopy = 0;
            while ( length > 0 ) {
                toCopy = length;
                if ( toCopy > _chunkSize - _currentBufferPosition ) {
                    toCopy = (int) _chunkSize - _currentBufferPosition;
                }
                System.arraycopy( b, offset, _buffer, _currentBufferPosition, toCopy );
                _currentBufferPosition += toCopy;
                offset += toCopy;
                length -= toCopy;
                if ( _currentBufferPosition == _chunkSize ) {
                    _dumpBuffer( false );
                }
            }
        }
        
        /**
         * Processes/saves all data from {@link java.io.InputStream} and closes
         * the potentially present {@link java.io.OutputStream}. The GridFS file
         * will be persisted afterwards.
         */
        @Override
        public void close() {
            // write last buffer if needed
            _dumpBuffer( true );
            // finish stream
            _finishData();
            // save file obj
            GridFSInputFile.super.save();
        }
    }
}
