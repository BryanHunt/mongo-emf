// ServerError.java

package com.mongodb;

import org.bson.*;

/**
 * Represents a server error
 */
public class ServerError {
    
    ServerError( DBObject o ){
        _err = getMsg( o , null );
        if ( _err == null )
            throw new IllegalArgumentException( "need to have $err" );
        _code = getCode( o );
    }
    
    static String getMsg( BSONObject o , String def ){
        Object e = o.get( "$err" );
        if ( e == null )
            e = o.get( "err" );
        if ( e == null )
            e = o.get( "errmsg" );
        if ( e == null )
            return def;
        return e.toString();
    }

    static int getCode( BSONObject o ){
        Object c = o.get( "code" );
        if ( c == null )
            c = o.get( "$code" );
        
        if ( c == null )
            return -5;
        
        return ((Number)c).intValue();
    }
    
    /**
     * Gets the error String
     * @return
     */
    public String getError(){
        return _err;
    }

    /**
     * Gets the error code
     * @return
     */
    public int getCode(){
        return _code;
    }

    /**
     * returns true if the error is "not master", which usually happens when doing operation on slave
     * @return
     */
    public boolean isNotMasterError(){
        switch ( _code ){
        case 10054:
        case 10056:
        case 10058:
        case 10107:
        case 13435:
        case 13436:
            return true;
        }
        
        return _err.startsWith( "not master" );
    }

    @Override
    public String toString(){
        if ( _code > 0 )
            return _code + " " + _err;
        return _err;
    }    

    final String _err;
    final int _code;

}
