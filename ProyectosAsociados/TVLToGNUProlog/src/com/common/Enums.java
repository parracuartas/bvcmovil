package com.common;

/**
 * @author Hans Parra, Juan Cuartas
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

        public static TYPE cast(String value) {
            return TYPE.valueOf(value.toUpperCase());
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

        public static SHORT_ID cast(String value) {
            try {
                return SHORT_ID.valueOf(value.toUpperCase());
            } catch (Exception e) {
                return SHORT_ID.ID;
            }
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

        public static CARDINALITY cast(String value) {
            return CARDINALITY.valueOf(value.toUpperCase());
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

        public static HIERARCHICAL_FEATURE cast(String value) {
            try {
                return HIERARCHICAL_FEATURE.valueOf(value.toUpperCase());
            } catch (Exception e) {
                return HIERARCHICAL_FEATURE.NONE;
            }
        }
    };

    public enum CHILDREN_ID {

        SELECTEDCHILDREN("selectedchildren"),
        CHILDREN("children");
        private String _toString;

        CHILDREN_ID(String toString) {
            _toString = toString;
        }

        @Override
        public String toString() {
            return _toString;
        }

        public static CHILDREN_ID cast(String value) {
            return CHILDREN_ID.valueOf(value.toUpperCase());
        }
    };
}
