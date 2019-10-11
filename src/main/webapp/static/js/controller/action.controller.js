'use strict';

angular.module('myApp').controller('AnActionController', ['$scope', 'ActionService', '$location', function($scope, ActionService, location) {
    var self = this;
    self.user={ref:'',pack:'',description:''};
    self.users=[];

    var id = location.search()['id'];
    fetchAction(id);

    function fetchAction(id){
    	ActionService.fetchAction(id)
            .then(
            function(d) {
                self.actions = d;
                $scope.action = d;
            },
            function(errResponse){
                console.error('Error while fetching Actions');
            }
        );
    }
}]);
