'use strict';
application.controller('notesController', function ($scope, $rootScope, $http) {

    setTimeout(function () {
        var url = "/Notes/" + $rootScope.currentUser.id;
        $http({
            method: 'GET',
            url: url
        }).then(function successCallback(response) {
            var result = [];
            angular.forEach(response.data, function (row) {
                result.push(new Note(row.id, row.title, row.content, row.isOwner, row.collaborators, row.dateCreated, row.dateModified));
            });
            $scope.notes = result;
        }, function errorCallback(response) {
            console.log(response);
        });

    }, 1);

    $scope.addNote = function() {

        var url = "/Notes/";

        //$scope.currentNote.content = "asdfasdfadsf";

        console.log($scope.currentNote);

        var result = $http.put(url + $scope.currentNote.id, $scope.currentNote);


    };



    $scope.go = function (note) {
        $scope.currentNote = note;
        $scope.addNote();
    }
});