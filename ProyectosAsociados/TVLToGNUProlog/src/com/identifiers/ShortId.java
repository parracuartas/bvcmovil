package com.identifiers;

import com.common.Constants;
import com.common.Enums.SHORT_ID;

/**
 *
 * @author yuxi
 *
 * SHORT_ID = "root" | "this" | "parent" | ID ;
 */
public class ShortId extends Identifier {

    private SHORT_ID _type;

    public ShortId(String text) {
        super(Constants.REGEX_ID, text);
    }

    public SHORT_ID getType() {
        return _type;
    }

    @Override
    public void parse() {
        _type = SHORT_ID.cast(_text);
    }

    @Override
    public String toString() {
        return _text;
    }
}
