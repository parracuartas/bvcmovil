/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.identifiers;

import com.common.Enums.SHORT_ID;

/**
 *
 * @author yuxi
 * 
 * SHORT_ID = "root" | "this" | "parent" | ID ;
 */
public class ShortId extends Identifier {

    private SHORT_ID _type;

    public ShortId() {
    }

    public ShortId(String value) {
        super(value);
        if (SHORT_ID.valueOf(value) != null) {
            _type = SHORT_ID.valueOf(value);
        } else {
            _type = SHORT_ID.ID;
        }
    }

    public SHORT_ID getType() {
        return _type;
    }

    public void setType(SHORT_ID _type) {
        this._type = _type;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
