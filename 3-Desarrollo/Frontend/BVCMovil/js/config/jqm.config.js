/**********************************************************************************
 File:   jqm.config.js
 Date:   19 Jun 2013
 Author: Juan Cuartas
 
 Changes jQuery Mobile's default settings.
 
 Backbone.js and jQuery Mobile are providing a routing system but using both will
 Cause a conflict. For that, the solution is to disable one. In this case, we
 take out jQuery Mobile router and keep using Backbone’s one. In order to have
 the transition between the page, it must be trigger manually the function 
 $.changePage provided by jQuery Mobile, usually this one is used automatically
 by the JQM router.
 **********************************************************************************/
define(["jquery"], function ($) {

    "use strict";

    /**
     * When jQuery Mobile starts, it triggers a mobileinit event on the document
     * object. To override default settings, bind to mobileinit.
     */
    $(document).on("mobileinit", function () {

        // jQuery Mobile will automatically handle link clicks and form submissions
        // through Ajax, when possible. If false, URL hash listening will be
        // disabled as well, and URLs will load as ordinary HTTP requests.
        $.mobile.ajaxEnabled = false;

        // Enhancement to use history.replaceState in supported browsers, to
        // convert the hash-based Ajax URL into the full document path. Note that
        // is recommended disabling this feature if Ajax is disabled or if external
        // links are used extensively.
        $.mobile.pushStateEnabled = false;

        // jQuery Mobile will automatically bind the clicks on anchor tags in the
        // document. Setting this option to false will prevent all anchor click
        // handling including the addition of active button state and alternate
        // link bluring. This should only be used when attempting to delegate the
        // click management to another library or custom code.
        $.mobile.linkBindingEnabled = false;

        // jQuery Mobile will automatically listen and handle changes to the
        // location.hash. Disabling this will prevent jQuery Mobile from handling
        // hash changes, which allows to handle them or use simple deep-links
        // within a document that scroll to a particular id.
        $.mobile.hashListeningEnabled = false;

        // Prevents to changing the location bar when the function $.changePage
        // provided by jQuery Mobile is called.
        $.mobile.changePage.defaults.changeHash = false;

        // If jQuery Mobile is not in charge of page navigation, we also have to
        // manually remove the pages from the DOM when they are not used anymore.
        $("div[data-role='page']").on('pagehide', function (event, ui) { 
            $(event.currentTarget).remove(); 
        });
    });
});