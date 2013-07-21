/**********************************************************************************
 File:   router.js
 Date:   20 Jun 2013
 Author: Juan Cuartas

 This module will create Backbone router object and then expose the initialize()
 function to allow bootstrap the application. 
 
 We use the Backbone router as the nav system of the application. Every time the
 user clicks a link, jQuery mobile will change the hash segment which will trigger
 Backbone to navigate user to the right view via the Backbone router.
**********************************************************************************/
define(["jquery", "underscore", "backbone", "jqm"], function () {
    
    "use strict";

    /**
     * Define routes and mapping route. The root url "" is mapped to showHome() function, the same with "/#home" hash.
     */
    var Router = Backbone.Router.extend({
        routes: {
            "":         "showHome",
            "home":     "showHome",
            "list/:categoryId" : "showBooks",
            "*actions": "defaultAction"
        },
        defaultAction: function (actions) {
            this.showHome();
        },
        showHome: function (actions){
            // will render home view and navigate to homeView
            var homeView=new HomeView();
            homeView.render();
            this.changePage(homeView);
        },

        init: true,

        showBooks:function(categoryId){
            //create a collection
            var bookList=new BookCollection();
            //create book list view and pass bookList as the collection of the view
            var bookListView=new BookListView({collection:bookList});
            //need to pass this as context 
            bookListView.bind("renderCompleted:Books",this.changePage,this);
            //update view
            bookListView.update(categoryId);
        },

        /**
         * 1. changePage will insert view into DOM and then call changePage to
         *    enhance and transition.
         * 2. For the first page, jQuery mobile will present and enhance
         *    automatically.
         * 3. For the other page, we will call $.mobile.changePage() to enhance
         *    page and make transition.
         * 4. argument "view" is passed from event trigger
         */
        changePage: function (view) {
            
            // Add the attribute data-role="page" for each view's div.
            view.$el.attr('data-role', 'page');   
            
            // Append to DOM.
            $('body').append(view.$el);  

            if (!this.init) {
                $.mobile.changePage(
                    $(view.el), { changeHash: false }
                );
            } else {
                this.init = false;
            }
        }
    });

    var initialize = function () {
        var router = new Router();
        Backbone.history.start();
    };

    return {
        initialize: initialize
    };
});