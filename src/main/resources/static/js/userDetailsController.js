application.controller('userDetailsController', function ($scope, $rootScope, $http, $timeout) {

    $scope.data.user = {};
    $scope.data.password = {};

    $scope.loadUserDetails = function () {
        $timeout(function () {
            $http.get('/CurrentUser').success(function (response) {
                $scope.data.user = new User(response.id, response.username, response.firstName, response.lastName, response.email, response.roles);
                $scope.$rootScope.currentUser = $scope.data.user;
            });
        }, 100);
    };

    $scope.loadUserDetails();

    $scope.submitForm = function (isValid) {

        var user = new User($scope.data.user.id, $scope.data.user.username, $scope.data.user.firstName, $scope.data.user.lastName, $scope.data.user.email, $scope.data.user.roles);
        var password = $scope.data.password1;

        $http.put('/Accounts/' + user.id, user).success(function(response) {
            console.log(response);
            $scope.loadUserDetails();
        });
    };
});