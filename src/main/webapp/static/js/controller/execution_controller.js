'use strict';

angular.module('myApp').controller('ExecutionController', ['$scope', 'ExecutionService', function($scope, ExecutionService) {
    var self = this;
    self.user={ref:'',pack:'',description:''};
    self.users=[];

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


}]);
