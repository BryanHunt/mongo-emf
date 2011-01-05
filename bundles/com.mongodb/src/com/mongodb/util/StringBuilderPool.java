// StringBuilderPool.java

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

package com.mongodb.util;

public class StringBuilderPool extends SimplePool<StringBuilder> {

    /** Initializes a pool of a given number of StringBuilders, each of a certain size.
     * @param maxToKeep the number of string builders in the pool
     * @param maxSize the size of each string builder
     */
    public StringBuilderPool( String name , int maxToKeep , int maxSize ){
        super( "StringBuilderPool-" + name , maxToKeep , -1  );
        _maxSize = maxSize;
    }

    /** Create a new string builder.
     * @return the string builder
     */
    public StringBuilder createNew(){
        return new StringBuilder();
    }

    /** Checks that the given string builder is within the size limit.
     * @param buf the builder to check
     * @return if it is not too big
     */
    public boolean ok( StringBuilder buf ){
        if ( buf.length() > _maxSize )
            return false;
        buf.setLength( 0 );
        return true;
    }

    protected long memSize( StringBuilder buf ){
        return buf.length() * 2;
    }

    final int _maxSize;
}
