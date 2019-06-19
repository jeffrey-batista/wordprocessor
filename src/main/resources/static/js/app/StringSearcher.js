'use strict'

angular.module('demo.services', []).factory('StringSearcher', ["$http", "CONSTANTS", function($http, CONSTANTS) {

    var service = {};

    service.checkString = function(originalString) {
        var url = CONSTANTS.checkString + originalString
        return $http.get(url);
    }

    return service;

}]);