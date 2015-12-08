'use strict';

application.controller('adminController', function ($scope, $http, $rootScope, editableOptions) {

    $scope.function = {};
    $scope.data = {};
    $scope.data.newUser = {};

    editableOptions.theme = 'bs3';

    $scope.function.getUserList = function () {
        $http.get('/Accounts').success(function (response) {
            var users = [];
            angular.forEach(response, function (value) {
                if (value.username != $rootScope.currentUser.username) {
                    var isAdmin = false;
                    angular.forEach(value.roles, function (role) {
                        if (role === "ADMIN") {
                            isAdmin = true;
                        }
                    });
                    users.push(new User(value.id, value.username, value.firstName, value.lastName, value.email, value.roles, isAdmin));
                }
            });
            $scope.data.users = users;
        });
    };

    $scope.function.getUserList();

    $scope.function.updateUserList = function (user) {

        $scope.data.debugUser = user;

        if (user.isAdmin) {
            user.roles = ["USER", "ADMIN"];
        }
        else {
            user.roles = ["USER"];
        }

        var newUser = new User(user.id, user.username, user.firstName, user.lastName, user.email, user.roles);

        $http.put('/Accounts/' + user.id, user).success(function(response) {
            $scope.function.getUserList();
        });
    };

    $scope.function.removeUser = function (user) {

        $http.delete("/Accounts/" + user.id).success(function (response) {
            $scope.function.getUserList();
        });
    };

    $scope.function.addUser = function () {

        var newUser = new User($scope.data.newUser.id, $scope.data.newUser.username, $scope.data.newUser.firstName, $scope.data.newUser.lastName, $scope.data.newUser.email, $scope.data.newUser.roles, false);

        $http.post("/Accounts", newUser).success(function (response) {
            $scope.function.getUserList();
        });
    }

});