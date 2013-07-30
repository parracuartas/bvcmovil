package com.identifiers;

import com.common.Constants;
import com.common.Util;
import java.text.ParseException;

/**
 * ID = ("a"-"z" | "A"-"Z") ("a"-"z" | "A"-"Z" | "0-9" | "_")*;
 *
 * @author Hans Parra, Juan Cuartas
 */
public class Identifier {

    private String _regex;
    protected String _text;

    public Identifier(String regex, String text) {
        _regex = regex;
        _text = text;
    }

    public Identifier(String text) {
        this(Constants.REGEX_ID, text);
    }

    public boolean isValid() {
        return Util.matchRegex(_regex, _text);
    }

    public void compile() throws ParseException {
        if (isValid()) {
            parse();
        } else {
            throw new ParseException(_text, 0);
        }
    }

    public void parse() {
    }

    @Override
    public String toString() {
        return _text;
    }
}