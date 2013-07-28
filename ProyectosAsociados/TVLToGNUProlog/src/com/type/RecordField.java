/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.type;

/**
 *
 * @author yuxi
 */
public class RecordField {

    private SimpleType _simpleType;
    private String _id;
    private String _value;

    public RecordField() {
    }

    public RecordField(SimpleType _simpleType, String _id) {
        this._simpleType = _simpleType;
        this._id = _id;
    }

    public SimpleType getSimpleType() {
        return _simpleType;
    }

    public void setSimpleType(SimpleType _simpleType) {
        this._simpleType = _simpleType;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return _simpleType + " {" + _id + " " + _value + "};";
    }
}
