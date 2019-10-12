'use strict';

angular.module('myApp').factory('InquiryService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/StackStormManagement/inquiries/';
	 
    var factory = {
    	fetchAllActions: fetchAllActions,
    	fetchAction: fetchAction,
    	getActionEntryPoints: getActionEntryPoints
    };
    return factory;

    function getInquiry(id) {
        var deferred = $q.defer();
        $http({
 		    method: 'GET', 
 		    url: REST_SERVICE_URI + "/" + id
 		}).then(
           function (response) {
               deferred.resolve(response.data);
           },
           function(errResponse){
               console.error('Error while fetching inquiry');
               deferred.reject(errResponse);
           }
       );
       return deferred.promise;
   }
    response
    function response(id, isApproved) {
        var deferred = $q.defer();
        $http({
 		    method: 'GET', 
 		    data: {id:id, response: {approved: isApproved}},
 		    url: REST_SERVICE_URI
 		}).then(
           function (response) {
               deferred.resolve(response.data);
           },
           function(errResponse){
               console.error('Error while fetching inquiry');
               deferred.reject(errResponse);
           }
       );
       return deferred.promise;
   }

}]);
