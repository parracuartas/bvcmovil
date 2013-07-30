package com.values;

import com.common.Constants;

/**
 * STRING = '"' [^] '"'
 * 
 * @author Hans Parra, Juan Cuartas
 */
public class TvlString extends TvlValue {

    public TvlString(String text) {
        super(Constants.REGEX_STRING_VALUE, text);
    }
    
    public String getValue() throws Exception {
        if (isValid()) {
            return _text.substring(1, _text.length() - 1);
        } else {
            throw new Exception(_text + " is not a valid String");
        }
    }
}