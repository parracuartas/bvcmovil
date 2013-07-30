package com.values;

import com.common.Constants;

/**
 * BOOLEAN = "true|false*
 * 
 * @author Hans Parra, Juan Cuartas
 */
public class TvlBoolean extends TvlValue {

    public TvlBoolean(String text) {
        super(Constants.REGEX_BOOLEAN_VALUE, text);
    }
    
    public boolean getValue() throws Exception {
        if (isValid()) {
            return Boolean.parseBoolean(_text);
        } else {
            throw new Exception(_text + " is not a valid Boolean");
        }
    }
}