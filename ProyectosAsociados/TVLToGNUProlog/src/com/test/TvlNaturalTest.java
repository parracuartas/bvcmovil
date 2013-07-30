package com.test;

import com.values.TvlNatural;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * NATURAL = "0" | ["1" -"9"]["0" -"9"]*
 * 
 * @author Hans Parra, Juan Cuartas
 */
public class TvlNaturalTest {
    
    @Test
    public void testInvalidNaturals() {
        // Invalid: the empty string
        assertFalse(new TvlNatural("").isValid());
        
        // Invalid: characters not allowed
        assertFalse(new TvlNatural("house").isValid());
        assertFalse(new TvlNatural("{}").isValid());
        assertFalse(new TvlNatural("...").isValid());
        assertFalse(new TvlNatural("anything").isValid());
        assertFalse(new TvlNatural("1 is not a antural").isValid());
        
        // Invalid: characters allowed, bad formed
        assertFalse(new TvlNatural("01").isValid());
        assertFalse(new TvlNatural("001").isValid());
        assertFalse(new TvlNatural("0001").isValid());
        
         // Invalid: negative numbers
        assertFalse(new TvlNatural("-1").isValid());
        assertFalse(new TvlNatural("-12").isValid());
        assertFalse(new TvlNatural("-123").isValid());
    }
    
    @Test
    public void testValidNaturals() {
        // Valid: zero
        assertTrue(new TvlNatural("0").isValid());
        
        // Valid: positive numbers
        assertTrue(new TvlNatural("1").isValid());
        assertTrue(new TvlNatural("12").isValid());
        assertTrue(new TvlNatural("123").isValid());
    }
    
    @Test
    public void testGetValue() {
        assertEquals(new TvlNatural("100").getValue(), 100);
    }
    
    @Test(expected=NumberFormatException.class)
    public void testNumberFormatException() {
        new TvlNatural("-1").getValue();
    }
}