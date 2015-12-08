'use strict';

application.controller('notesController', function ($scope, $rootScope, $http, $timeout) {

    $scope.collaborators = {};
    $scope.data = {};

    $scope.loadNotes = function () {



        $timeout(function () {
            $http.get("/Notes/" + $rootScope.currentUser.id).success(function (response) {
                var result = [];
                angular.forEach(response, function (row) {
                    var note = new Note(row.id, row.title, row.content, row.owner, row.collaborators, row.dateCreated, row.dateModified);
                    result.push(note);
                });
                $scope.data.notes = result;
                var index = 0;
                var date = 0;
                angular.forEach($scope.data.notes, function (item, key) {
                    if (item.dateModified > date) {
                        date = item.dateModified;
                        index = key;
                    }
                });
                $scope.data.currentNote = $scope.data.notes[index];
                $scope.idSelectedVote = $scope.data.currentNote.id;
            });
        }, 1);
    };

    $scope.loadNotes();

    $http({
        method: 'GET',
        url: "/Accounts/UserSelectList"
    }).then(function successCallback(response) {
        var result = [];
        angular.forEach(response.data, function (item) {
            result.push({
                id: item.id,
                name: item.firstName + " " + item.lastName
            });
        });
        $scope.users = result;
    }, function errorCallback(response) {
        console.log(response);
    });

    $scope.updateCollaboratorList = function (selectedUsers) {
        $scope.data.currentNote.collaborators = [];
        $scope.data.currentNote.collaborators.push($scope.currentUser.id);
        angular.forEach(selectedUsers, function (user) {
            $scope.data.currentNote.collaborators.push(user.id);
        });
        $scope.saveNote();
    };

    $scope.viewSelectedNote = function (note) {
        $scope.idSelectedVote = note.id;
        var result = [];
        angular.forEach(note.collaborators, function (collaboratorId) {
            angular.forEach($scope.users, function (user) {
                if (collaboratorId === user.id) {
                    result.push({
                        id: user.id,
                        name: user.name
                    });
                }
            });
        });

        $scope.collaborators.selected = result;
        $scope.data.currentNote = note;
    };

    $scope.deleteNote = function () {
        $http.delete("/Notes/" + $scope.data.currentNote.id).success(function (response) {
            $scope.loadNotes();
        });
    };

    $scope.saveNote = function () {
        $http.put("/Notes/" + $scope.data.currentNote.id, $scope.data.currentNote).success(function (response) {
            $scope.loadNotes();
        });
    };

    $scope.addNote = function () {
        $http.post("/Notes/" + $scope.currentUser.id).success(function (response) {
            $scope.loadNotes();
        });

    };
});

