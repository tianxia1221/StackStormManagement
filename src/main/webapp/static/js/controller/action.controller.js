'use strict';

angular.module('myApp').controller('AnActionController', ['$scope', 'ActionService', 'ExecutionService', '$location', function($scope, ActionService, ExecutionService, location) {
    var self = this;
    self.executionAction = executionAction;
    self.key = 'bag';
    self.result ="";

    var id = location.search()['id'];
    fetchAction(id);
    getActionEntryPoints(id);

    function fetchAction(id){
    	ActionService.fetchAction(id)
            .then(
            function(d) {
                self.actions = d;
                $scope.action = d;
            },
            function(errResponse){
                console.error('Error while fetching Action');
            }
        );
    }
    
    function getActionEntryPoints(id){
    	ActionService.getActionEntryPoints(id)
            .then(
            function(d) {
                self.entryPoints = d;
            },
            function(errResponse){
                console.error('Error while fetching Action');
            }
        );
    }
    
    function executionAction(){
     //   var name = self。key;
    	ExecutionService.fetchExecution(self.key)
            .then(
            function(d) {
            	alert("An instance of the action is started successfully");
            	console.log('An instance of the action is started successfully');
            },
            function(errResponse){
                console.error('Error while fetching Action');
            }
        );
    }
    
    
}]);
