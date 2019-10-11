'use strict';

angular.module('myApp').controller('ActionsController', ['$scope', 'ActionService', '$location', function($scope, ActionService, location) {
    var self = this;
    self.user={ref:'',pack:'',description:''};
    self.users=[];
    self.showDetails = showDetails;
    fetchAllActions();

    function fetchAllActions(){
    	//location.url('StackStormManagement/oneaction');
    	ActionService.fetchAllActions()
            .then(
            function(d) {
                self.actions = d;
            },
            function(errResponse){
                console.error('Error while fetching Actions');
            }
        );
    }
    
    function showDetails(id){
    	location.url('action'+ "?id=" + id );
    }


}]);
