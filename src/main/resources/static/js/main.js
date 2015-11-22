var application = angular.module('application', ['ngRoute'])

    .run(function ($rootScope, $http) {

        $http({
            method: 'GET',
            url: '/CurrentUser'
        }).then(function successCallback(response) {
            $rootScope.currentUser = response.data;
            $rootScope.isAdmin = false;
            angular.forEach($rootScope.currentUser.roles, function(role, index) {
               if (role === "ADMIN")
               {
                   $rootScope.isAdmin = true;
               }
            });

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





