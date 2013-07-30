package com.test;

import com.values.TvlReal;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * REAL = INTEGER "." (["0" -"9"]*["1" -"9"])?
 * 
 * @author Hans Parra, Juan Cuartas
 */
public class TvlRealTest {
    
    @Test
    public void testInvalidReals() {
        // Invalid: the empty string
        assertFalse(new TvlReal("").isValid());
        
        // Invalid: characters not allowed
        assertFalse(new TvlReal("house").isValid());
        assertFalse(new TvlReal("{}").isValid());
        assertFalse(new TvlReal("***").isValid());
        assertFalse(new TvlReal("anything").isValid());
        assertFalse(new TvlReal("1 is not a real").isValid());
        
        // Invalid: characters allowed, bad formed
        assertFalse(new TvlReal("-").isValid());
        assertFalse(new TvlReal("0-0").isValid());
        assertFalse(new TvlReal("1-0").isValid());
        assertFalse(new TvlReal("0-").isValid());
        assertFalse(new TvlReal("01").isValid());
        assertFalse(new TvlReal("..").isValid());
        assertFalse(new TvlReal(".0.0").isValid());
        
        // Invalid: integers
        assertFalse(new TvlReal("0").isValid());
        assertFalse(new TvlReal("1").isValid());
        assertFalse(new TvlReal("12").isValid());
        assertFalse(new TvlReal("123").isValid());
        assertFalse(new TvlReal("-1").isValid());
        assertFalse(new TvlReal("-12").isValid());
        assertFalse(new TvlReal("-123").isValid());
        
        // Invalid: ending with zero after non-zero decimal
        assertFalse(new TvlReal("0.10").isValid());
        assertFalse(new TvlReal("1.100").isValid());
        assertFalse(new TvlReal("1.1000").isValid());
    }
    
    @Test
    public void testValidReals() {
        // Valid: zero
        assertTrue(new TvlReal("0.0").isValid());
        
        // Valid: positive numbers
        assertTrue(new TvlReal("1.0").isValid());
        assertTrue(new TvlReal("12.1").isValid());
        assertTrue(new TvlReal("123.2").isValid());
        
        // Valid: negative numbers
        assertTrue(new TvlReal("-1.1").isValid());
        assertTrue(new TvlReal("-12.2").isValid());
        assertTrue(new TvlReal("-123.3").isValid());
        
        // Valid: ending with a dot
        assertTrue(new TvlReal("0.").isValid());
        assertTrue(new TvlReal("-1.").isValid());
        assertTrue(new TvlReal("-1.").isValid());
    }
    
    @Test
    public void testGetValue() {
        assertEquals(new TvlReal("100.0").getValue(), 100.0, 0);
    }
    
    @Test(expected=NumberFormatException.class)
    public void testNumberFormatException() {
        new TvlReal("abc...").getValue();
    }
}