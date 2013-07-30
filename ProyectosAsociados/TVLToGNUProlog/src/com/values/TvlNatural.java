package com.values;

import com.common.Constants;

/**
 * NATURAL = "0" | ["1" -"9"]["0" -"9"]*
 * 
 * @author Hans Parra, Juan Cuartas
 */
public class TvlNatural extends TvlValue {

    public TvlNatural(String text) {
        super(Constants.REGEX_NATURAL_VALUE, text);
    }
    
    public int getValue() throws NumberFormatException {
        if (isValid()) {
            return Integer.parseInt(_text);
        } else {
            throw new NumberFormatException(_text + " is not a valid Natural");
        }
    }
}