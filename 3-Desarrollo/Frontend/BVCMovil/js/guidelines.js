// -----------------------------------------------------------------------------
/**
 * @file      Here goes file description. Filenames should be all lowercase in
 *            order to avoid confusion on case-sensitive platforms.
 * @version   1.0
 * @author    Juan Cuartas <equisoide@gmail.com>
 * @copyright Juan Cuartas, 2013
 * @requires  some/module
 */
// -----------------------------------------------------------------------------

/*******************************************************************************
 DOCUMENTATION
 *******************************************************************************/

// Inline comments should be like this.

/**
 * Block comments to be documented WITH JSDoc should be like this. Start
 * sentences with a properly capitalized word, and end them with punctuation.
 */

/***
 Block comments to be documented WITHOUT JSDoc should be like this.

 All files, classes, methods and properties should be documented with JSDoc
 with the appropriate tags and types.
 
 JSDoc tags:
  @access Specifies the access level of a member: private, protected, public.
  @author Identifies the author of an item.
  @callback Documents a callback function.
  @class Marks a function as a class.
  @constant {type} Marks an object as a constat.
  @copyright Documents some copyright information.
  @default Documents a default value.
  @enum {type} Marks an object as an enumeration.
  @extends Indicates that a class inherits from another class.
  @file Provides a description for a file.
  @ignore Removes a JSDoc item from the final output.
  @link Links to a JSDoc namepath or an external URL.
  @module Documents a JavaScript module.
  @namespace Marks an object as a namespace.
  @param {type} Documents a parameter of a function.
  @requires Describes a required module.
  @return {type} Documents the return value of a function.
  @type {type} Documents the type of an object.
  @version Documents the version number of an item.

 JSDoc types:
  - Primitive types: {boolean}, {number}, {string}
  - Instance types:  {myNamespace.MyClass}, {{a: type, b: type>}}, {type[]}
  - Functions:       {function(a: type, b: type): type}
  - Nullable types:  {?type}
  - Variable args:   {...type}

 For more information about JSDoc check out {@link http://usejsdoc.org} 
 */

/*******************************************************************************
 VARIABLES
 *******************************************************************************/

/**
 * Use lowerCamelCase for variable names.
 *
 * When you fail to specify var, the variable gets placed in the global context,
 * potentially clobbering existing values. Also, if there's no declaration,
 * it's hard to tell in what scope a variable lives (e.g., it could be in the
 * Document or Window just as easily as in the local scope). So always declare
 * with var.
 *
 * @type {string}
 * @default
 */
var variableName = "Some value";

// Related variables of the same type CAN be declared in a common statement;
// unrelated variables SHOULD NOT be declared in the same statement. Var
// statements should always be in the beginning of their respective scope.
var variableA = 1,
    variableB = 2,
    variableC = 3;

/*******************************************************************************
 CONSTANTS
 *******************************************************************************/

/**
 * Use UPPER_CASE for constant names. Words should be separated through
 * underscore character. Always add the @const annotation.
 *
 * @const
 * @type {boolean}
 * @default
 */
var CONSTANT_NAME = true;

/*******************************************************************************
 NAMESPACES
 *******************************************************************************/

/**
 * Always prefix identifiers in the global scope with a unique pseudo namespace
 * related to the project or library. Use lowerCamelCase for namespaces. Always
 * add the @namespace annotation.
 *
 * @namespace
 */
var guidelines = guidelines || {};

/**
 * Use local aliases for fully-qualified types if doing so improves readability.
 * The name of a local alias should match the last part of the type. Never
 * create aliases in the global scope. Use them only in function blocks.
 *
 * @ignore
 */
guidelines.usingNamespaceAliasesCorrectly = function () {
    var MyClass = some.long.namespace.MyClass;
    doSomething( new MyClass() );
};

/**
 * Do not create local aliases for no fully-qualified types, as shown below.
 *
 * @ignore
 */
guidelines.usingNamespaceAliasesWrong = function () {
    var namespace = some.long.namespace;
    doSomething( new namespace.MyClass() );
};

/*******************************************************************************
 DECLARATIONS
 *******************************************************************************/

// Always use this way, don't use "new Array()".
var myArray = [];

// Always use this way, don't use "new Object()".
var myObject = {};

// Prefer double quotes over single quotes.
var myString = "";

/*******************************************************************************
 SPACES
 *******************************************************************************/

// if, while, for and function always have spaces, braces and span multiple
// lines. This encourages readability.

if ( condition ) { 
    // Do something...
}

while ( condition ) {
    // Do something...
}

for ( var index in collection ) {
    // Do something...
}

function foo( arg ) {
    // Do something...
}

var someFunction = function ( arg ) {
    // Do something...
}

someFunction( arg );

// Functions with callbacks, NO SPACE.
foo(function () {
});

// Function accepting an array, NO SPACE.
foo(["alpha", "beta"]);

// Function accepting an object, NO SPACE.
foo({
    a: "alpha",
    b: "beta"
});

// Single argument string literal, NO SPACE.
foo("bar");

/*******************************************************************************
 IF - ELSE
 *******************************************************************************/

// Because of implicit semicolon insertion, always start your curly braces on
// the same line as whatever they're opening. For example:
if ( something ) {
    // Do something...
} else {
    // Do something else...
}

/*******************************************************************************
 FOR-IN LOOP
 *******************************************************************************/

// Always use normal for loops when using arrays. For-in loops are often
// incorrectly used to loop over the elements in an Array. This is however very
// error prone because it does not loop from 0 to length - 1 but over all the
// present keys in the object and its prototype chain.
var array  = ["a", "b", "c"],
    index  = 0,
    length = array.length;

for ( ; index < length; index++ ) {
    print( array[index] );
}

/*******************************************************************************
 FUNCTIONS
 *******************************************************************************/

/**
 * Use lowerCamelCase for function names.
 *
 * @param {number} arg - This is a description for "arg".
 * @return {number} If the function returns something, it must be specified.
 */
guidelines.functionName = function ( arg ) {
    return arg + 1;
};

/**
 * Nullable arguments must be specified throught query character.
 *
 * @param {?number} arg - This is a description for "arg".
 */
guidelines.functionWithNullableArgument = function ( arg ) {
    if ( arg ) {
        // Do something...
    }
};

/**
 * Optional arguments should start with "opt_".
 *
 * @param {number} opt_arg - This is a description for "opt_arg".
 */
guidelines.functionWithOptionalArgument = function ( opt_arg ) {
    if ( arguments.length === 1 ) {
        // Do something...
    }
};

/**
 * Functions that take a variable number of arguments should have the last
 * argument named var_args. You may not refer to var_args in the code; use the
 * arguments array.
 *
 * @param {number} arg1 - This is a description for "arg1".
 * @param {number} arg2 - This is a description for "arg2".
 * @param {...number} var_args - This is a description for "var_args".
 */
guidelines.functionWithVariableArguments = function ( arg1, arg2, var_args ) {
    var index  = 2,
        lenght = arguments.length;

    for ( ; index < lenght ; i++ ) {
        // Do something...
    }
};

/**
 * Callback arguments should start with "fn_".
 *
 * @param {someFunction} fn_callback - This is a description for "fn_callback".
 */
guidelines.functionWithCallbackArgument = function ( fn_callback ) {
    fn_callback("some argument");
};

////////////////////////////////////////////////////////////////////////////////
/**
 * This is the full documentation for {someFunction} type, defined in the
 * function guidelines.functionWithCallbackArgument(). Always add the @callback
 * annotation when documenting callback functions.
 *
 * @callback someFunction
 * @param {string} someArgument - This is a description for "someArgument".
 */
////////////////////////////////////////////////////////////////////////////////

/**
 * Illustrates line wrapping for long param/return descriptions.
 *
 * @param {string} arg - This is a param with a description too long to fit in
 *     one line.
 * @return {number} This returns something that has a description too long to
 *     fit in one line.
 */
guidelines.functionWithLongDescriptions = function ( arg ) {
    return arg;
};

/**
 * When possible, all function arguments should be listed on the same line. If
 * doing so would exceed the 80-column limit, the arguments must be line-wrapped
 * in a readable way.
 *
 * @param {string} veryDescriptiveArgumentNumberOne - Description 1...
 * @param {string} veryDescriptiveArgumentTwo -  Description 2...
 * @param {string} veryDescriptiveArgumentThree - Description 3...
 */
guidelines.functionThatIsVeryDifficultToExplain = function (
    veryDescriptiveArgumentNumberOne,
    veryDescriptiveArgumentTwo,
    veryDescriptiveArgumentThree ) {

    // Do something...
};

/*******************************************************************************
 SEMICOLONS AND FUNCTIONS
 *******************************************************************************/

/**
 * Semicolons should be included at the end of function expressions.
 */
var functionExpression = function () {
    return true;
};

/**
 * Semicolons must not be at the end of function declarations.
 */
function functionDelaration() {
    return true;
}

/*******************************************************************************
 FUNCTION DECLARATIONS WHITIN BLOCKS
 *******************************************************************************/

// Do not do this.
if ( x ) {
    function foo() {
    }
}

// Do this: ECMAScript only allows for Function Declarations in the root
// statement list of a script or function.
if ( x ) {
    var foo = function () {
    };
}

/*******************************************************************************
 CIRCULAR REFERENCES IN CLOSURES
 *******************************************************************************/

/**
 * Do not do this: the function closure keeps a reference to element, a, and b
 * even if it never uses element. Since element also keeps a reference to the
 * closure, we have a cycle that won't be cleaned up by garbage collection.
 *
 * @param {Object} element - This is a description for "element".
 * @param {number} a - This is a description for "a".
 * @param {number} b - This is a description for "b".
 */
guidelines.createCircularReference = function ( element, a, b ) {
    element.onclick = function () {
        /* uses a and b */
    };
};

/**
 * This is the way circular references can be avoided.
 *
 * @param {Object} element - This is a description for "element".
 * @param {number} a - This is a description for "a".
 * @param {number} b - This is a description for "b".
 */
guidelines.avoidCircularReference = function ( element, a, b ) {
    element.onclick = functionOutsideFoo( a, b );
};

/*******************************************************************************
 ENUMERATIONS
 *******************************************************************************/

/**
 * Use UperCamelCase for enum names. Always add the @enum annotation following
 * enum type.
 *
 * @enum {string}
 */
var MyEnumeration = {
    ITEMA: "A",
    ITEMB: "B",
    ITEMC: "C"
};

/*******************************************************************************
 CLASSES
 *******************************************************************************/

/**
 * Use UperCamelCase for class names. Always add the @class annotation.
 *
 * @class
 */
function MyClass() {

    /**
     * Private properties should be named with a trailing underscore.
     *
     * @alias MyClass#publicAttribute
     * @type {number}
     * @default
     */
    var _privateAttribute = 1;

    /**
     * Private methods should be named with a trailing underscore.
     *
     * @alias MyClass#publicMethod
     */
    var _privateMethod = function () {
    };

    // It´s a good practice to override the toString method for custom clases.
    // It should be implemented as follow:

    /**
     * Returns a string that represents the current object.
     *
     * @alias MyClass#toString
     * @return {string} A string that represents the current object.
     */
    var _toString = function () {
        return _privateAttribute.toString();
    };

    return {
        publicAttribute: _privateAttribute,
        publicMethod:    _privateMethod,
        toString:        _toString
    };
}

/*******************************************************************************
 BOOLEAN EXPRESSIONS
 *******************************************************************************/

/***
  The following are all false in boolean expressions:
   - null
   - undefined
   - "" the empty string
   - 0 the number
*/

/* USE */ while ( x ) { }     /* INSTEAD OF */ while ( x != null ) { }

/* USE */ if ( y ) { }        /* INSTEAD OF */ if ( y != null && y != "" ) { }

/* USE */ if ( array.length ) /* INSTEAD OF */ if ( array.length > 0 ) { }

/*******************************************************************************
 TYPE CHECKS
 *******************************************************************************/

/***
 String:            typeof object === "string"
 Number:            typeof object === "number"
 Boolean:           typeof object === "boolean"
 Object:            typeof object === "object"
 
 Null:              object === null
 Null or undefined: object == null

 Undefined:
    Global Variables: typeof variable === "undefined"
    Local Variables:  variable === undefined
    Properties:       object.prop === undefined
*/