'use strict';
var application = angular.module('application', ['ngRoute', 'ngResource', 'textAngular', 'ui.select', 'ngSanitize'])

    .run(function ($rootScope, $http) {

        $http.get('/CurrentUser').success(function (response) {
            $rootScope.currentUser = new User(response.id, response.userName, response.firstName, response.lastName, response.email, response.roles);
        });
    })

    .config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

        $routeProvider.when('/Notes', {
            templateUrl: 'pages/notes.html',
            controller: 'notesController'
        });

        $routeProvider.when('/UserDetails', {
            templateUrl: 'pages/userDetails.html',
            controller: 'userDetailsController'
        });

        $routeProvider.when('/Admin', {
            templateUrl: 'pages/admin.html',
            controller: 'adminController'
        });

        $routeProvider.otherwise({redirectTo: '/Notes'});

        $locationProvider.html5Mode({enabled: true, requireBase: false});
    }]);





