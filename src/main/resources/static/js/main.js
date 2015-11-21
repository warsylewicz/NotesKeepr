var application = angular.module('scotchApp', ['ngRoute']);

application.controller('mainController', function($scope) {

    $scope.message = 'Everyone come and see how good I look!';
});