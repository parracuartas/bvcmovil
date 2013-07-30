package com.common;

/**
 * @author Hans Parra, Juan Cuartas
 */
public class Constants {

    public static final String REGEX_INTEGER_VALUE = "(0|(-)?[1-9]\\d*)";
    public static final String REGEX_NATURAL_VALUE = "(0|[1-9]\\d*)";
    public static final String REGEX_REAL_VALUE = REGEX_INTEGER_VALUE + "\\." + "(0|[0-9]*[1-9])?";
    public static final String REGEX_BOOLEAN_VALUE = "true|false";
    public static final String REGEX_STRING_VALUE = "\"(.*)\"";
    
    public static final String REGEX_ID = "([a-z]|[A-Z])(([a-z]|[A-Z]|[0-9]|[_])*)";
    public static final String REGEX_LONG_ID = REGEX_ID + "(\\." + REGEX_ID + ")*";
    public static final String REGEX_CHILDREN_ID = "(selectedchildren|children)" + "(\\." + REGEX_LONG_ID + ")*";
}