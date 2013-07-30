package com.values;

import com.common.Constants;

/**
 * REAL = INTEGER "." (["0" -"9"]*["1" -"9"])?
 * 
 * @author Hans Parra, Juan Cuartas
 */
public class TvlReal extends TvlValue {

    public TvlReal(String text) {
        super(Constants.REGEX_REAL_VALUE, text);
    }
    
    public double getValue() throws NumberFormatException {
        if (isValid()) {
            return Double.parseDouble(_text);
        } else {
            throw new NumberFormatException(_text + " is not a valid Real");
        }
    }
}