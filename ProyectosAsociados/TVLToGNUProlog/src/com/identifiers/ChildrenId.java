package com.identifiers;

import com.common.Constants;
import com.common.Enums.CHILDREN_ID;

/**
 *
 * @author Hans Parra, Juan Cuartas
 *
 * CHILDREN_ID = "selectedchildren" "." LONG_ID | "children" "." LONG_ID ;
 */
public class ChildrenId extends Identifier {

    private CHILDREN_ID _type;
    private LongId _longId;

    public ChildrenId(String value) {
        super(Constants.REGEX_CHILDREN_ID, value);
    }

    @Override
    public void parse() {
        _type = CHILDREN_ID.cast(_text.substring(0, _text.indexOf(".")));
        _longId = new LongId(_text.substring(_text.indexOf(".") + 1, _text.length()));
    }

    public CHILDREN_ID getType() {
        return _type;
    }

    public void setType(CHILDREN_ID _type) {
        this._type = _type;
    }

    public LongId getLongId() {
        return _longId;
    }

    public void setLongId(LongId _longId) {
        this._longId = _longId;
    }

    @Override
    public String toString() {
        return _text;
    }
}
