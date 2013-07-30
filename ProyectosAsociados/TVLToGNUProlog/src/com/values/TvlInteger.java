package com.values;

import com.common.Constants;

/**
 * INTEGER = "0" | ("-")?["1"-"9"]["0"-"9"]*
 * 
 * @author Hans Parra, Juan Cuartas
 */
public class TvlInteger extends TvlValue {
    
    public TvlInteger(String text) {
        super(Constants.REGEX_INTEGER_VALUE, text);
    }
    
    public int getValue() throws NumberFormatException {
        if (isValid()) {
            return Integer.parseInt(_text);
        } else {
            throw new NumberFormatException(_text + " is not a valid Integer");
        }
    }
}