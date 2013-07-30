package com.test;

import com.values.TvlInteger;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * INTEGER = "0" | ("-")?["1"-"9"]["0"-"9"]*
 * 
 * @author Hans Parra, Juan Cuartas
 */
public class TvlIntegerTest {
    
    @Test
    public void testInvalidIntegers() {
        // Invalid: the empty string
        assertFalse(new TvlInteger("").isValid());
        
        // Invalid: characters not allowed
        assertFalse(new TvlInteger("house").isValid());
        assertFalse(new TvlInteger("{}").isValid());
        assertFalse(new TvlInteger("...").isValid());
        assertFalse(new TvlInteger("anything").isValid());
        assertFalse(new TvlInteger("1 is not an integer").isValid());
        
        // Invalid: characters allowed, bad formed
        assertFalse(new TvlInteger("-").isValid());
        assertFalse(new TvlInteger("0-0").isValid());
        assertFalse(new TvlInteger("1-0").isValid());
        assertFalse(new TvlInteger("0-").isValid());
        assertFalse(new TvlInteger("01").isValid());
    }
    
    @Test
    public void testValidIntegers() {
        // Valid: zero
        assertTrue(new TvlInteger("0").isValid());
        
        // Valid: positive numbers
        assertTrue(new TvlInteger("1").isValid());
        assertTrue(new TvlInteger("12").isValid());
        assertTrue(new TvlInteger("123").isValid());
        
        // Valid: negative numbers
        assertTrue(new TvlInteger("-1").isValid());
        assertTrue(new TvlInteger("-12").isValid());
        assertTrue(new TvlInteger("-123").isValid());
    }
    
    @Test
    public void testGetValue() {
        assertEquals(new TvlInteger("100").getValue(), 100);
    }
    
    @Test(expected=NumberFormatException.class)
    public void testNumberFormatException() {
        new TvlInteger("abc...").getValue();
    }
}