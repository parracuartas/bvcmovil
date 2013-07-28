/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author yuxi
 */
public class FeatureGroup {

    private final String GROUP = "group";
    private Cardinality _cardinality;
    private List<HierachicalFeature> _features;

    public FeatureGroup(String expression) {
        expression = expression.replace(GROUP, "");
        expression = expression.trim();
        _features = new ArrayList();

        String cardinaltyExpression = expression.substring(0, expression.indexOf("{"));
        String features = expression.substring(expression.indexOf("{") + 1, expression.lastIndexOf("}"));
        StringTokenizer featureTok = new StringTokenizer(features, ",");
        while (featureTok.hasMoreTokens()) {
            String feature = featureTok.nextToken().trim();
            HierachicalFeature hf = new HierachicalFeature(feature);
            _features.add(hf);
        }
        _cardinality = new Cardinality(cardinaltyExpression);

        //_cardinality = new Cardinality(cardinality)

    }
}
