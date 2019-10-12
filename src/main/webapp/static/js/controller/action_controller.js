'use strict';

angular.module('myApp').controller('ActionController', ['$scope', 'ActionService', '$location', function($scope, ActionService, location) {
    var self = this;

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
    
    function fetchOneActions(){
    	window.location="/index#/index/clientTakeGoods/clientTakeGoodsResult"
    }
    


}]);
