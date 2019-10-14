'use strict';

angular.module('myApp').controller('InquiryController', ['$scope', 'InquiryService', 'ExecutionService',  '$location', function($scope, InquiryService, ExecutionService, location) {
    var self = this;
    var id = location.search()['id'];
    
    self.response = response;
    
    getInquiry(id);

    function getInquiry(id){
    	ExecutionService.getInquiry(id)
            .then(
            function(d) {
                self.inquiry = d;
            },
            function(errResponse){
                console.error('Error while fetching inquiry');
            }
        );
    }

    function response(){
    	InquiryService.response(self.inquiry.id, self.inquiry.result.response.approved)
            .then(
            function(d) {
            	alert('Response successfully');
            	console.log('Response successfully');
            },
            function(errResponse){
                console.error('Error while fetching inquiry');
            }
        );
    }

}]);
