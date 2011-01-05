// DBCursor.java

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

package com.mongodb;

import java.util.*;

import com.mongodb.DBApiLayer.MyCollection;
import com.mongodb.DBApiLayer.Result;


/** An iterator over database results.
 * Doing a <code>find()</code> query on a collection returns a 
 * <code>DBCursor</code> thus
 *
 * <blockquote><pre>
 * DBCursor cursor = collection.find( query );
 * if( cursor.hasNext() )
 *     DBObject obj = cursor.next();
 * </pre></blockquote>
 *
 * <p><b>Warning:</b> Calling <code>toArray</code> or <code>length</code> on
 * a DBCursor will irrevocably turn it into an array.  This 
 * means that, if the cursor was iterating over ten million results
 * (which it was lazily fetching from the database), suddenly there will
 * be a ten-million element array in memory.  Before converting to an array,
 * make sure that there are a reasonable number of results using 
 * <code>skip()</code> and <code>limit()</code>.
 * <p>For example, to get an array of the 1000-1100th elements of a cursor, use 
 *
 * <blockquote><pre>
 * List<DBObject> obj = collection.find( query ).skip( 1000 ).limit( 100 ).toArray();
 * </pre></blockquote>
 *
 * @dochub cursors
 */
public class DBCursor implements Iterator<DBObject> , Iterable<DBObject> {

    /**
     * Initializes a new database cursor
     * @param collection collection to use
     * @param q query to perform
     * @param k keys to return from the query
     */
    public DBCursor( DBCollection collection , DBObject q , DBObject k ){
        _collection = collection;
        _query = q == null ? new BasicDBObject() : q;
        _keysWanted = k;
        if ( _collection != null ){
            _options = _collection.getOptions();
        }
    }

    /** Types of cursors: iterator or array. */
    static enum CursorType { ITERATOR , ARRAY };

    /**
     * Creates a copy of an existing database cursor.
     * The new cursor is an iterator, even if the original 
     * was an array.
     *
     * @return the new cursor
     */
    public DBCursor copy() {
        DBCursor c = new DBCursor(_collection, _query, _keysWanted);
        c._orderBy = _orderBy;
        c._hint = _hint;
        c._numWanted = _numWanted;
        c._skip = _skip;
        c._options = _options;
        c._batchSize = _batchSize;
        if ( _specialFields != null )
            c._specialFields = new BasicDBObject( _specialFields.toMap() );
        return c;
    }

    public Iterator<DBObject> iterator(){
        return this.copy();
    }

    // ---- querty modifiers --------

    /**
     * Sorts this cursor's elements.
     * @param orderBy the fields on which to sort
     * @return a cursor pointing to the first element of the sorted results
     */
    public DBCursor sort( DBObject orderBy ){
        if ( _it != null )
            throw new IllegalStateException( "can't sort after executing query" );

        _orderBy = orderBy;
        return this;
    }

    /**
     * add a special operator like $maxScan or $returnKey
     * e.g. addSpecial( "$returnKey" , 1 )
     * e.g. addSpecial( "$maxScan" , 100 )
     * @dochub specialOperators
     */
    public DBCursor addSpecial( String name , Object o ){
        if ( _specialFields == null )
            _specialFields = new BasicDBObject();
        _specialFields.put( name , o );
        return this;
    }

    /**
     * Informs the database of indexed fields of the collection in order to improve performance.
     * @param indexKeys an <code>DBObject</code> with index names as keys
     * @return same DBCursor for chaining operations
     */
    public DBCursor hint( DBObject indexKeys ){
        if ( _it != null )
            throw new IllegalStateException( "can't hint after executing query" );
        
        if ( indexKeys == null )
            _hint = null;
        else 
            _hint = DBCollection.genIndexName( indexKeys );
        return this;
    }

    /**
     * Use snapshot mode for the query.  Snapshot mode assures no duplicates are 
     * returned, or objects missed, which were present at both the start and end 
     * of the query's execution (if an object is new during the query, or deleted 
     * during the query, it may or may not be returned, even with snapshot mode).
     * Note that short query responses (less than 1MB) are always effectively snapshotted.
     * Currently, snapshot mode may not be used with sorting or explicit hints.
     * @return same DBCursor for chaining operations
     */
    public DBCursor snapshot() {
        if (_it != null)
            throw new IllegalStateException("can't snapshot after executing the query");

        _snapshot = true;

        return this;
    }


    /**
     *  Informs the database of an indexed field of the collection in order to improve performance.
     * @param indexName the name of an index
     * @return same DBCursort for chaining operations
     */
    public DBCursor hint( String indexName ){
        if ( _it != null )
            throw new IllegalStateException( "can't hint after executing query" );

        _hint = indexName;
        return this;
    }

    /**
     * Returns an object containing basic information about the
     * exectution of the query that created this cursor
     * This creates a <code>DBObject</code> with the key/value pairs:
     * "cursor" : cursor type
     * "nScanned" : number of records examined by the database for this query
     * "n" : the number of records that the database returned
     * "millis" : how long it took the database to execute the query
     * @return a <code>DBObject</code>
     * @dochub explain
     */
    public DBObject explain(){
        DBCursor c = copy();
        c._explain = true;
        c._numWanted = c._numWanted * -1;
        return c.next();
    }

    /**
     * <p>Limits the number of elements returned.</p> 
     * <p><b>Note</b>: Specifying a <i>negative number</i> instructs the server to return that number of items 
     * and to close the cursor. It will only return what can fit in a <i>single 4mb response</i>.</p>
     * @param n the number of elements to return
     * @return a cursor pointing to the first element of the limited results
     * @dochub limit
     */
    public DBCursor limit( int n ){
        if ( _it != null )
            throw new IllegalStateException( "can't set limit after executing query" );

        _numWanted = n;
        return this;
    }

    /**
     * Limits the number of elements returned in one batch
     * @param n the number of elements to return in a batch
     */
    public DBCursor batchSize( int n ){
//        if ( n < 1 )
//            throw new IllegalArgumentException( "batchSize has to be >= 1" );
        if ( n == 1 )
            n = 2;
        if ( _it != null )
        	if (_it instanceof DBApiLayer.Result)
        		((DBApiLayer.Result)_it).setNumberToReturn(n);

        _batchSize = n;
        return this;
    }

    /**
     * Discards a given number of elements at the beginning of the cursor.
     * @param n the number of elements to skip
     * @return a cursor pointing to the new first element of the results
     * @throws RuntimeException if the cursor has started to be iterated through
     */
    public DBCursor skip( int n ){
        if ( _it != null )
            throw new IllegalStateException( "can't set skip after executing query" );
        _skip = n;
        return this;
    }

    /** The cursor (id) on the server; 0 = no cursor */
    public long getCursorId() {
    	if ( _it instanceof Result )
            return ((Result)_it).getCursorId();
    	
    	return 0;
    }
    
    /** kill the current cursor on the server. */
    public void close() {
    	if ( _it instanceof Result )
            ((Result)_it).close();
    }
    
    /**
     * makes this query ok to run on a slave node
     */
    public DBCursor slaveOk(){
        return addOption( Bytes.QUERYOPTION_SLAVEOK );
    }

    /**
     * adds an option - see Bytes.QUERYOPTION_* for list
     */
    public DBCursor addOption( int option ){
        _options |= option;
        return this;
    }

    public void setOptions( int options ){
        _options = options;
    }

    public void resetOptions(){
        _options = 0;
    }

    public int getOptions(){
        return _options;
    }

    // ----  internal stuff ------

    private void _check()
        throws MongoException {
        if ( _it != null )
            return;
        
        if ( _collection != null && _query != null ){

            _lookForHints();

            DBObject foo = _query;
            if ( hasSpecialQueryFields() ){
                foo = _specialFields == null ? new BasicDBObject() : _specialFields;
                
                _addToQueryObject( foo , "query" , _query , true );
                _addToQueryObject( foo , "orderby" , _orderBy , false );
                _addToQueryObject( foo , "$hint" , _hint );

                if ( _explain )
                    foo.put( "$explain" , true );
                if ( _snapshot )
                    foo.put( "$snapshot", true );
            }

            int bs = _numWanted;
            if ( _batchSize > 0 ){
                if ( _numWanted == 0 )
                    bs = _batchSize;
                else
                    bs = Math.min( bs , _batchSize );
            }
            _it = _collection.__find( foo , _keysWanted , _skip , bs , _options );
        }

        if ( _it == null ){
            _it = (new LinkedList<DBObject>()).iterator();
            _fake = true;
        }
    }
    
    /**
     * if there is a hint to use, use it
     */
    private void _lookForHints(){
        
        if ( _hint != null ) // if someone set a hint, then don't do this
            return;

        if ( _collection._hintFields == null )
            return;

        Set<String> mykeys = _query.keySet();

        for ( DBObject o : _collection._hintFields ){
            
            Set<String> hintKeys = o.keySet();

            if ( ! mykeys.containsAll( hintKeys ) )
                continue;

            hint( o );
            return;
        }
    }

    boolean hasSpecialQueryFields(){
        if ( _specialFields != null )
            return true;

        if ( _orderBy != null && _orderBy.keySet().size() > 0 )
            return true;
        
        if ( _hint != null || _snapshot )
            return true;
        
        return _explain;
    }

    void _addToQueryObject( DBObject query , String field , DBObject thing , boolean sendEmpty ){
        if ( thing == null )
            return;
        
        if ( ! sendEmpty && thing.keySet().size() == 0 )
            return;
    
        _addToQueryObject( query , field , thing );
    }

    void _addToQueryObject( DBObject query , String field , Object thing ){

        if ( thing == null )
            return;
        
        query.put( field , thing );
    }

    void _checkType( CursorType type ){
        if ( _cursorType == null ){
            _cursorType = type;
            return;
        }

        if ( type == _cursorType )
            return;

        throw new IllegalArgumentException( "can't switch cursor access methods" );
    }

    private DBObject _next()
        throws MongoException {
        if ( _cursorType == null )
            _checkType( CursorType.ITERATOR );

        _check();

        _cur = null;
        _cur = _it.next();
        _num++;

        if ( _keysWanted != null && _keysWanted.keySet().size() > 0 ){
            _cur.markAsPartialObject();
            //throw new UnsupportedOperationException( "need to figure out partial" );
        }

        if ( _cursorType == CursorType.ARRAY ){
            _all.add( _cur );
        }

        return _cur;
    }

    public int numGetMores(){
        if ( _fake )
            return 0;

        if ( _it instanceof DBApiLayer.Result )
            return ((DBApiLayer.Result)_it).numGetMores();

        throw new IllegalArgumentException("_it not a real result" );
    }

    public List<Integer> getSizes(){
        if ( _fake )
            return new LinkedList<Integer>();

        if ( _it instanceof DBApiLayer.Result )
            return ((DBApiLayer.Result)_it).getSizes();

        throw new IllegalArgumentException("_it not a real result" );
    }
    
    private boolean _hasNext()
        throws MongoException {
        _check();

        if ( _numWanted > 0 && _num >= _numWanted )
            return false;

        return _it.hasNext();
    }

    /**
     * Returns the number of objects through which the cursor has iterated.
     * @return the number of objects seen
     */
    public int numSeen(){
        return _num;
    }

    // ----- iterator api -----

    /**
     * Checks if there is another element.
     * @return if there is another element
     */
    public boolean hasNext(){
        _checkType( CursorType.ITERATOR );
        try {
            return _hasNext();
        }
        catch ( MongoException e ){
            throw new MongoInternalException( "couldn't get next element" , e );
        }
    }
    
    /**
     * Returns the element the cursor is at and moves the cursor ahead by one.
     * @return the next element
     */
    public DBObject next(){
        _checkType( CursorType.ITERATOR );
        try {
            return _next();
        }
        catch ( MongoException e ){
            throw new MongoInternalException( "couldn't get next element" , e );
        }
    }

    /**
     * Returns the element the cursor is at.
     * @return the next element
     */
    public DBObject curr(){
        _checkType( CursorType.ITERATOR );
        return _cur;
    }

    /**
     * Unimplemented.
     */
    public void remove(){
        throw new UnsupportedOperationException( "can't remove from a cursor" );
    }


    //  ---- array api  -----

    void _fill( int n )
        throws MongoException {
        _checkType( CursorType.ARRAY );
        while ( n >= _all.size() && _hasNext() )
            _next();
    }

    /** 
     * pulls back all items into an array
     * this is slow
     * @see count()
     * @see size()
     * @return the number of elements in the array
     */
    public int length()
        throws MongoException {
        _checkType( CursorType.ARRAY );
        _fill( Integer.MAX_VALUE );
        return _all.size();
    }

    /** Converts this cursor to an array.
     * @return an array of elements
     */
    public List<DBObject> toArray()
        throws MongoException {
        return toArray( Integer.MAX_VALUE );
    }
    
    /**
     * Converts this cursor to an array.  If there are more than a given number of elements in the resulting array, only return the first <tt>min</tt>.
     * @param min the minimum size of the array to return
     * @return an array of elements
     */
    public List<DBObject> toArray( int min )
        throws MongoException {
        _checkType( CursorType.ARRAY );
        _fill( min );
        return _all;
    }
    
    /**
     * for testing only!
     * iterates cursor and counts objects
     * very slow
     * @see count()
     * @return num objects
     */
    public int itcount(){
        int n = 0;
        while ( this.hasNext() ){
            this.next();
            n++;
        }
        return n;
    }

    /**
     * Counts the number of elements matching the query
     * this does not take limit/skip into consideration
     * @see size()
     * @return the number of elements
     */
    public int count() 
        throws MongoException {
        if ( _collection == null )
            throw new IllegalArgumentException( "why is _collection null" );
        if ( _collection._db == null )
            throw new IllegalArgumentException( "why is _collection._db null" );
        
        return (int)_collection.getCount(this._query, this._keysWanted);
    }

    /**
     * Counts the number of elements matching the query that would be returned
     * this does take limit/skip into consideration
     * @see count()
     * @return the number of elements
     */
    public int size() 
        throws MongoException {
        if ( _collection == null )
            throw new IllegalArgumentException( "why is _collection null" );
        if ( _collection._db == null )
            throw new IllegalArgumentException( "why is _collection._db null" );
        
        return (int)_collection.getCount(this._query, this._keysWanted, this._numWanted, this._skip );
    }

    
    public DBObject getKeysWanted(){
        return _keysWanted;
    }
    
    public DBObject getQuery(){
        return _query;
    }

    // ----  query setup ----
    private final DBCollection _collection;
    private final DBObject _query;
    private final DBObject _keysWanted;
    
    private DBObject _orderBy = null;
    private String _hint = null;
    private boolean _explain = false;
    private int _numWanted = 0;
    private int _batchSize = 0;
    private int _skip = 0;
    private boolean _snapshot = false;
    private int _options = 0;

    private DBObject _specialFields;

    // ----  result info ----
    private Iterator<DBObject> _it = null;
    private boolean _fake = false;

    private CursorType _cursorType = null;
    private DBObject _cur = null;
    private int _num = 0;

    private final ArrayList<DBObject> _all = new ArrayList<DBObject>();
}
