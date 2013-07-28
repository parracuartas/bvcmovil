/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.feature.FeatureGroup;
import com.identifiers.Identifier;
import com.identifiers.LongId;
import com.values.Real;

/**
 *
 * @author yuxi
 */
public class TVLToGNUPrologMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        String expression = " group    someof  {Nissan, opt Ford, a1123}";
//        FeatureGroup f = new FeatureGroup(expression);
        
        System.out.println(new  Real("-10.123").isValid());
        System.out.println(new  Real("0.23647523847239496236489789 23040 ").isValid());
        System.out.println(new  Real("asd").isValid());

    }
}
