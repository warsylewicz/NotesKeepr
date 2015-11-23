'use strict';
var application = angular.module('application', ['ngRoute', 'ngResource'])

    .run(function ($rootScope, $http) {
        $http({
            method: 'GET',
            url: '/CurrentUser'
        }).then(function successCallback(response) {



            $rootScope.currentUser = new User(response.data.id, response.data.userName, response.data.firstName, response.data.lastName, response.data.email, response.data.roles);
        }, function errorCallback(response) {
            console.log(response);
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





