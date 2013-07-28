/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.type;

/**
 *
 * @author yuxi
 */
public class Record {

    private final String STRUCT = "Struct";
    private String _id;
    private RecordField _recordField;

    public Record() {
    }

    public Record(String _id, RecordField _recordField) {
        this._id = _id;
        this._recordField = _recordField;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public RecordField getRecordField() {
        return _recordField;
    }

    public void setRecordField(RecordField _recordField) {
        this._recordField = _recordField;
    }

    @Override
    public String toString() {
        return STRUCT + " " + _id + " {" + _recordField + "};";
    }
}
