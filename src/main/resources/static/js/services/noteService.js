//application.factory('NoteService', function ($resource) {
//    return $resource('/Note/FindAll', {}, {
//        query: {
//            method: 'GET',
//            transformResponse: function (data) {
//                return angular.fromJson(data).events;
//            },
//            isArray: true
//        }
//    });
//});

application.factory('NoteService',
    function($resource) {

        var wrap = function(_) {
            // forward declaration -- function redefined below
        };

        function extend(item) {
            return angular.extend(new Note(), item);
        }


        var res =  $resource('/Note/FindAll', {}, {
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: function(data, headersGetter) {
                    var items = angular.fromJson(data);
                    var models = [];
                    angular.forEach(items, function(item) {
                        models.push($.extend({}, item));
                    });
                    console.log("models: ", models);
                    return models;
                }
            }
        });

        //wrap = function(data) {
        //    var T = Note;
        //    T.prototype = res.prototype;
        //    var instance = new T();
        //    angular.extend(instance, data);
        //    return instance;
        //};

        res.newModel = function() {
            return wrap({});
        };

        return res;

        return res;
    }
);