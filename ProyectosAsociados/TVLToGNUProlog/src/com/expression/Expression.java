/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expression;

/**
 *
 * @author yuxi
 */
public abstract class Expression {
    
    private String _text;
    
    public Expression(String text) {
        _text = text;
    }
    
    public abstract Object evaluate();
}