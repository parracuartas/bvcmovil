/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.identifiers;

/**
 *
 * @author yuxi
 *
 * LONG_ID = SHORT_ID | SHORT_ID "." LONG_ID ;
 */
public class LongId extends ShortId {

    private LongId _longId;

    public LongId(String value) {
        if (!value.contains(".")) {
            _value = value;
        } else {
            _value = value.substring(0, value.indexOf("."));
            _longId = new LongId(value.substring(value.indexOf(".") + 1, value.length()));
        }
    }

    @Override
    public boolean isValid() {
        if (_longId == null) {
            return super.isValid();
        } else {
            return super.isValid() && _longId.isValid();
        }
    }

    public LongId getLongId() {
        return _longId;
    }

    public void setLongId(LongId _longId) {
        this._longId = _longId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
