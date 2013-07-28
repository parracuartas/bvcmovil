/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feature;

import com.common.Enums.HIERARCHICAL_FEATURE;
import com.identifiers.LongId;
import com.model.Feature;

/**
 *
 * @author yuxi
 *
 * HIERARCHICAL_FEATURE = ( "opt" )? FEATURE | ( "shared" | "opt" )? LONG_ID ;
 */
public class HierachicalFeature {

    private HIERARCHICAL_FEATURE _type;
    private Feature _feature;
    private LongId _longId;

    public HierachicalFeature(String expression) {
        expression = expression.trim();

        if (expression.startsWith(HIERARCHICAL_FEATURE.OPT.toString())) {
            expression = expression.substring(3).trim();
            _type = HIERARCHICAL_FEATURE.OPT;
        } else if (expression.startsWith(HIERARCHICAL_FEATURE.SHARED.toString())) {
            expression = expression.substring(6).trim();
            _type = HIERARCHICAL_FEATURE.SHARED;
        } else {
            _type = HIERARCHICAL_FEATURE.NONE;
        }

        LongId longId = new LongId(expression);
        if (longId.isValid()) {
            _longId = new LongId(expression);
        } else {
            _feature = new Feature();
        }
    }

    public HIERARCHICAL_FEATURE getType() {
        return _type;
    }

    public void setType(HIERARCHICAL_FEATURE _type) {
        this._type = _type;
    }

    public Feature getFeature() {
        return _feature;
    }

    public void setFeature(Feature _feature) {
        this._feature = _feature;
    }

    public LongId getLongId() {
        return _longId;
    }

    public void setLongId(LongId _longId) {
        this._longId = _longId;
    }
}
