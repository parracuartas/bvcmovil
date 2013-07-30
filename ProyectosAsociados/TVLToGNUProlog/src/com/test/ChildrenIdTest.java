package com.test;

import com.identifiers.ChildrenId;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * INTEGER = "0" | ("-")?["1"-"9"]["0"-"9"]*
 *
 * @author Hans Parra, Juan Cuartas
 */
public class ChildrenIdTest {

    @Test
    public void testInvalidChildrenId() {

        // Invalid: characters not allowed
        assertTrue(new ChildrenId("selectedchildren.abc").isValid());
        assertTrue(new ChildrenId("children.abc").isValid());
        assertTrue(new ChildrenId("selectedchildrens.abc").isValid());
        assertTrue(new ChildrenId("childrens.abc").isValid());
        assertTrue(new ChildrenId("selectedchildrens.123").isValid());
        assertTrue(new ChildrenId("childrens._132").isValid());
        assertFalse(new ChildrenId("childrens...").isValid());
    }
}