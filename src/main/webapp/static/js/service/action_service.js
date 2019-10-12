'use strict';

angular.module('myApp').factory('ActionService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/StackStormManagement/action/';
	var REST_SERVICE_URI_ENTRY_POINTS = 'http://localhost:8080/StackStormManagement/action/views/entry_point';
	 
    var factory = {
    	fetchAllActions: fetchAllActions,
    	fetchAction: fetchAction,
    	getActionEntryPoints: getActionEntryPoints
    };
    return factory;

    function fetchAllActions() {
        var deferred = $q.defer();
    	$http({
		    method: 'GET',
		    url: REST_SERVICE_URI
		}).then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Actions');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchAction(id) {
      var deferred = $q.defer();
       $http({
		    method: 'GET', 
		    params: { id: id},
		    url: REST_SERVICE_URI
		}).then(
          function (response) {
              deferred.resolve(response.data);
          },
          function(errResponse){
              console.error('Error while fetching Actions');
              deferred.reject(errResponse);
          }
      );
      return deferred.promise;
  }
    
    
    function getActionEntryPoints(id) {
        var deferred = $q.defer();
        $http({
 		    method: 'GET', 
 		    params: { id: id},
 		    url: REST_SERVICE_URI_ENTRY_POINTS
 		}).then(
           function (response) {
               deferred.resolve(response.data);
           },
           function(errResponse){
               console.error('Error while fetching Actions');
               deferred.reject(errResponse);
           }
       );
       return deferred.promise;
   }

}]);
