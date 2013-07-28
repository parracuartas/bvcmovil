/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.common.Enums.TYPE;
import com.identifiers.Identifier;

/**
 *
 * @author yuxi
 */
public class Constant extends Model {

    private final String CONST = "const";
    private TYPE _type;
    private Identifier _id;
    private String _value;

    public Constant() {
    }

    public Constant(TYPE _type, Identifier _id, String _value) {
        this._type = _type;
        this._id = _id;
        this._value = _value;
    }

    public TYPE getType() {
        return _type;
    }

    public void setType(TYPE _type) {
        this._type = _type;
    }

    public Identifier getId() {
        return _id;
    }

    public void setId(Identifier _id) {
        this._id = _id;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String _value) {
        this._value = _value;
    }

    @Override
    public String toString() {
        return CONST
                + " "
                + _type.toString()
                + " "
                + _id
                + " "
                + _value
                + ";";
    }
}
