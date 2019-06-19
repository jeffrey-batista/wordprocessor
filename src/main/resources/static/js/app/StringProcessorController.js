'use strict'

var module = angular.module('demo.controllers', []);

module.controller("StringProcessorController", ["$scope", "StringSearcher",

    function ($scope, StringSearcher) {

        $scope.checkString = function () {

            StringSearcher.checkString($scope.originalString).then(function (value) {
                if (value.data == -9) {
                    $scope.output = "string too short";
                }
                if (value.data == -8) {
                    $scope.output = "no keywords found in string";
                }
                if (value.data >0)
                {
                    $scope.output = value.data;
                }
            });

        }
    }

]);

