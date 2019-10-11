'use strict';

angular.module('myApp').factory('ActionService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/StackStormManagement/action/';

    var factory = {
    	fetchAllActions: fetchAllActions,
    	fetchAction: fetchAction
    };
    return factory;

    function fetchAllActions() {
        var deferred = $q.defer();
//        $http.get(REST_SERVICE_URI)
//          .then(
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
    
    
    function fetchOneActions(id) {
        var deferred = $q.defer();
	    $http.get(REST_SERVICE_URI+id)
	       .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching an Action');
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

}]);
