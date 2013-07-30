/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feature;

import com.common.Enums.CARDINALITY;

/**
 *
 * @author yuxi
 */
public class Cardinality {

    private CARDINALITY _type;
    private String _initial;
    private String _final;

    public Cardinality(String expression) {
        expression = expression.trim();
        if (expression.contains("[")) {
            _type = CARDINALITY.EXPRESSION;
            _initial = expression.substring(expression.indexOf("[") + 1, expression.indexOf(".."));
            _final = expression.substring(expression.indexOf("..") + 2, expression.indexOf("]"));
        } else {
            _type = CARDINALITY.cast(expression);
        }
    }

    public CARDINALITY getType() {
        return _type;
    }

    public void setType(CARDINALITY _type) {
        this._type = _type;
    }

    public String getInitial() {
        return _initial;
    }

    public void setInitial(String _initial) {
        this._initial = _initial;
    }

    public String getFinal() {
        return _final;
    }

    public void setFinal(String _final) {
        this._final = _final;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
