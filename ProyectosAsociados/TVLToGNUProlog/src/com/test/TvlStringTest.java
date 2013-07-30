package com.test;

import com.values.TvlString;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * STRING = '"' [^] '"'
 * 
 * @author Hans Parra, Juan Cuartas
 */
public class TvlStringTest {
    
    @Test
    public void testInvalidStrings() {
        assertFalse(new TvlString("").isValid());
        assertFalse(new TvlString("abc...xyz").isValid());
        assertFalse(new TvlString("\"abc...xyz").isValid());
        assertFalse(new TvlString("abc...xyz\"").isValid());
    }
    
    @Test
    public void testValidStrings() {
        assertTrue(new TvlString("\"\"").isValid());
        assertTrue(new TvlString("\"abc...xyz\"").isValid());
    }
    
    @Test
    public void testGetValue() throws Exception {
        assertEquals(new TvlString("\"abc...xyz\"").getValue(), "abc...xyz");
    }
    
    @Test(expected=Exception.class)
    public void testException() throws Exception {
        new TvlString("abc...xyz").getValue();
    }
}