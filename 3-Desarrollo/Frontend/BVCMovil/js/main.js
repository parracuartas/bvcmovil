// -----------------------------------------------------------------------------
/**
 * @file      Application entry point. In this module, we configure Require.js
 *            and jQuery Mobile and then bootstrap the application.
 * @version   1.0
 * @author    Juan Cuartas <equisoide@gmail.com>
 * @copyright Juan Cuartas, 2013
 */
// -----------------------------------------------------------------------------

// Sets the Require.js configuration.
require.config({
    paths: {
        jquery:      "lib/jquery",
        jqm:         "lib/jquery.mobile",
        underscore:  "lib/underscore",
        backbone:    "lib/backbone",
        backbonels:  "lib/backbone.localstorage",
        json:        "lib/json",
        requiretext: "lib/require.text"
    }
});

// Require.js will load and evaluate router.js and jqm.config.js first as the
// dependencies of the module. Once the module is loaded we can call
// Router.initialize() to bootstrap the application.
require(["app/router", "config/jqm.config"], function ( Router ) {
    Router.initialize();
});