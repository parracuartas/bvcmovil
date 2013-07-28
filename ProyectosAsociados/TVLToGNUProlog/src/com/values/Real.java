/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.values;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author yuxi
 */
public class Real extends Value {

    public Real(String value) {
        super(value);
    }

    @Override
    public boolean isValid() {
        Pattern pattern = Pattern.compile("^(0|(-)?([1-9]\\d*)).([0-9]*[1-9])?$");
        Matcher matcher = pattern.matcher(_value);
        return matcher.find();
    }
}
