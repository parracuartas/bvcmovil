/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

/**
 *
 * @author yuxi
 */
public class Enums {

    public enum TYPE {

        INT("int"),
        REAL("real"),
        ENUM("enum"),
        BOOL("bool");
        private String _toString;

        TYPE(String toString) {
            _toString = toString.toUpperCase();
        }

        @Override
        public String toString() {
            return _toString;
        }
    };

    public enum SHORT_ID {

        ROOT("root"),
        THIS("this"),
        PARENT("parent"),
        ID("id");
        private String _toString;

        SHORT_ID(String toString) {
            _toString = toString;
        }

        @Override
        public String toString() {
            return _toString;
        }
    };

    public enum CARDINALITY {

        ONEOF("oneof"),
        SOMEOF("someof"),
        ALLOF("allof"),
        EXPRESSION("expresion");
        private String _toString;

        CARDINALITY(String toString) {
            _toString = toString.toUpperCase();
        }

        @Override
        public String toString() {
            return _toString;
        }
    };

    public enum HIERARCHICAL_FEATURE {

        OPT("opt"),
        SHARED("shared"),
        NONE("none");
        private String _toString;

        HIERARCHICAL_FEATURE(String toString) {
            _toString = toString;
        }

        @Override
        public String toString() {
            return _toString;
        }
    };
}
