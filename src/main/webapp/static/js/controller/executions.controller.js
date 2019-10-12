'use strict';

angular.module('myApp').controller('ExecutionsController', ['$scope', 'ExecutionService',  '$location', function($scope, ExecutionService, location) {
    var self = this;
    self.showDetails = showDetails;
    
    fetchAllExecutions();

    function fetchAllExecutions(){
    	ExecutionService.fetchAllExecutions()
            .then(
            function(d) {
                self.executions = d;
            },
            function(errResponse){
                console.error('Error while fetching Executions');
            }
        );
    }

    function showDetails(id){
    	location.url('execution'+ "?id=" + id );
    }

}]);
