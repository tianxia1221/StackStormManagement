'use strict';

angular.module('myApp').controller('InquiriesController', ['$scope', 'ExecutionService',  '$location', function($scope, ExecutionService, location) {
    var self = this;
    self.showDetails = showDetails;
    
    getInquiries();

    function getInquiries(){
    	ExecutionService.getInquiries()
            .then(
            function(d) {
                self.inquiries = d;
            },
            function(errResponse){
                console.error('Error while fetching inquiries');
            }
        );
    }

    function showDetails(id){
    	location.url('inquiry'+ "?id=" + id );
    }

}]);
