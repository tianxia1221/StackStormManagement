'use strict';

angular.module('myApp').controller('ActionController', ['$scope', 'ActionService', function($scope, ActionService) {
    var self = this;
    self.user={ref:'',pack:'',description:''};
    self.users=[];

    fetchAllActions();

    function fetchAllActions(){
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


}]);
