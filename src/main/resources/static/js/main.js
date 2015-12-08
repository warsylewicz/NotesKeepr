'use strict';
var application = angular.module('application', ['ngRoute',
        'ngResource',
        'textAngular',
        'ui.select',
        'ngSanitize',
        'frapontillo.bootstrap-switch',
        'xeditable'])

    .run(function ($rootScope, $http) {
        $http.get('/CurrentUser').success(function (response) {

            var isAdmin = false;
            angular.forEach(response.roles, function (item) {
               if (item === "ADMIN")
               {
                   isAdmin = true;
               }
            });
            $rootScope.currentUser = new User(response.id, response.username, response.firstName, response.lastName, response.email, response.roles, isAdmin);
            $rootScope.isAdmin = isAdmin;
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





