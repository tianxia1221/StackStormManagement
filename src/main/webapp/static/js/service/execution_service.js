'use strict';

angular.module('myApp').factory('ExecutionService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/StackStormManagement/execution/';

    var factory = {
    	fetchAllExecutions: fetchAllExecutions
    };
    return factory;

    function fetchAllExecutions() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Executions');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
