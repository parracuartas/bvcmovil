package com.values;

import com.common.Util;

/**
 * @author Hans Parra, Juan Cuartas
 *
 * VALUE = NATURAL | INTEGER | REAL | STRING
 */
public abstract class TvlValue {
    
    private String _regex;
    protected String _text;
    
    public TvlValue(String regex, String text) {
        _regex = regex;
        _text = text;
    }
    
    public boolean isValid() {
        return Util.matchRegex(_regex, _text);
    }
    
    @Override
    public String toString() {
        return _text;
    }
}