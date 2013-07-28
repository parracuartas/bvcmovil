/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.type;

import com.common.Enums.TYPE;
import com.common.SetExpresion;
import com.model.Type;

/**
 *
 * @author yuxi
 */
public class SimpleType extends Type {

    private TYPE _type;
    private String _id;
    private SetExpresion _setExpresion;

    public SimpleType() {
    }

    public SimpleType(TYPE _type, String _id, SetExpresion _setExpresion) {
        this._type = _type;
        this._id = _id;
        this._setExpresion = _setExpresion;
    }

    public TYPE getType() {
        return _type;
    }

    public void setType(TYPE _type) {
        this._type = _type;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public SetExpresion getSetExpresion() {
        return _setExpresion;
    }

    public void setSetExpresion(SetExpresion _setExpresion) {
        this._setExpresion = _setExpresion;
    }

    @Override
    public String toString() {
        return _type.toString()
                + " "
                + _id
                + _setExpresion != null ? " in " + _setExpresion : ""
                + ";";
    }
}
