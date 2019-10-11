'use strict';

angular.module('myApp').controller('namesCtrl', ['$scope', function($scope) {

    $scope.names = [
        {name:'Jani',country:'Norway'},
        {name:'Hege',country:'Sweden'},
        {name:'Kai',country:'Denmark'}
    ];

}]);
