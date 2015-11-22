application.controller('notesController', function ($scope, $rootScope, $http) {
    $scope.message = 'These are my notes!!!';

    var userId = $rootScope.currentUser;

    console.log(userId);

    var url = '/Note/' + userId;

    $http({
        method: 'GET',
        url: url
    }).then(function successCallback(response) {
        console.log(response);

    }, function errorCallback(response) {
        console.log(response);
    });


});