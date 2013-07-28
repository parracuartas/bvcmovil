/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.identifiers;

/**
 *
 * @author yuxi
 *
 * ID = ("a"-"z" | "A"-"Z") | ("a"-"z" | "A"-"Z" | "0-9" | "_")*;
 */
public class Identifier {

    protected String _value;

    public Identifier() {
    }

    public Identifier(String value) {
        this._value = value;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String _value) {
        this._value = _value;
    }

    /**
     * This is a great algorithm made by JC. Hans is a dummy.
     *
     * @author Juan Cuartas
     * @return
     */
    public boolean isValid() {
        if (_value.length() == 0) {
            return false;
        } else if (!Character.isLetter(_value.charAt(0))) {
            return false;
        } else {
            for (int i = 1; i < _value.length(); i++) {
                if (!Character.isLetter(_value.charAt(i))
                        && !Character.isDigit(_value.charAt(i))
                        && _value.charAt(i) != '_') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return _value;
    }
}