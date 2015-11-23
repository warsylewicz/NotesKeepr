'use strict'
class User {
    constructor(id, userName, firstName, lastName, email, roles) {
        this.id = id;
        this.username = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    isAdmin() {

        var value = false;

        angular.forEach(this.roles, function (role) {
            if (role === "ADMIN") {
                value = true;
            }
        });
        return value;
    }

    getFullName() {
        return this.firstName + " " + this.lastName;
    }

    getId()
    {
        return this.id;
    }
}

//application.factory('CurrentUser', function () {
//    function CurrentUser(id, userName, firstName, lastName, email, roles) {
//        this.id = id;
//        this.username = userName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.roles = roles;
//    }
//
//    CurrentUser.prototype.isAdmin = function () {
//        var value = false;
//
//        angular.forEach(this.roles, function (role) {
//            if (role === "ADMIN") {
//                value = true;
//            }
//        });
//        return value;
//    };
//
//    CurrentUser.prototype.getFullName = function () {
//        return this.firstName + " " + this.lastName;
//    };
//
//    return CurrentUser;
//});
