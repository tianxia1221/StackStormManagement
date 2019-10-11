'use strict';

angular.module('myApp').controller('OneActionController', ['$scope', 'ActionService', function($scope, ActionService) {
    var self = this;
    self.user={ref:'',pack:'',description:''};
    self.users=[];

    fetchOneActions();

    function fetchOneActions(){
    	ActionService.fetchOneActions()
            .then(
            function(d) {
                self.actions = d;
            },
            function(errResponse){
                console.error('Error while fetching an Action');
            }
        );
    }


}]);
