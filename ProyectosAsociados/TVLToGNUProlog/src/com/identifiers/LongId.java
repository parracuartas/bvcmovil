package com.identifiers;

import com.common.Constants;

/**
 * LONG_ID = SHORT_ID | SHORT_ID "." LONG_ID ;
 *
 * @author Hans Parra, Juan Cuartas
 */
public class LongId extends Identifier {

    private ShortId _shortId;
    private LongId _longId;

    public LongId(String text) {
        super(Constants.REGEX_LONG_ID, text);
    }

    public LongId getLongId() {
        return _longId;
    }

    public void setLongId(LongId _longId) {
        this._longId = _longId;
    }

    public ShortId getShortId() {
        return _shortId;
    }

    public void setShortId(ShortId _shortId) {
        this._shortId = _shortId;
    }

    @Override
    public String toString() {
        return _text;
    }

    @Override
    public void parse() {
        if (_text.contains(".")) {
            _shortId = new ShortId(_text.substring(0, _text.indexOf(".")));
            _longId = new LongId(_text.substring(_text.indexOf(".") + 1, _text.length()));
        } else {
            _shortId = new ShortId(_text);
        }
    }
}
