'use strict';

angular.module('myApp').controller('InquiryController', ['$scope', 'InquiryService',  '$location', function($scope, InquiryService, location) {
    var self = this;
    var id = location.search()['id'];
    
    self.response = response;
    
    getInquiry(id);

    function getInquiry(id){
    	InquiryService.getInquiry(id)
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
    	InquiryService.response(inquiry.id, true)
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
