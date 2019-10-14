'use strict';

angular.module('myApp').controller('AnExecutionController', ['$scope', 'ExecutionService',  '$location', function($scope, ExecutionService, location) {
    var self = this;
    self.user={ref:'',pack:'',description:''};
    self.users=[];

    var id = location.search()['id'];
    fetchExecution(id);

    function fetchExecution(id){
    	ExecutionService.fetchExecution(id)
            .then(
            function(d) {
                self.executions = d;
            },
            function(errResponse){
                console.error('Error while fetching Execution');
            }
        );
    }


}]);
