package com.values;

/**
 *
 * @author yuxi
 *
 * VALUE = NATURAL | INTEGER | REAL | STRING
 */
public abstract class Value {

    protected String _value;

    public Value(String _value) {
        this._value = _value;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String _value) {
        this._value = _value;
    }

    abstract boolean isValid();
}
