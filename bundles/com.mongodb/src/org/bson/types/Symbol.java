// Symbol.java

/**
 *      Copyright (C) 2009 10gen Inc.
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

package org.bson.types;

/**
 *  Class to hold a BSON symbol object, which is an interned string in Ruby
 */
public class Symbol {

    public Symbol(String s) {
        _symbol = s;
    }

    public String getSymbol(){
        return _symbol;
    }

    public String toString(){
        return _symbol;
    }

    private final String _symbol;
}
