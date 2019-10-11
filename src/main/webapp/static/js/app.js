'use strict';

var App = angular.module('myApp', [ 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				template : 'this is home'
			}).when('oneaction', {
		        templateUrl: 'StackStormManagement/OneActionManagement.jsp',
		        controller: 'OneActionController'
			}).when('/printers', {
				template : 'thist is printer'
			}).otherwise({
				redirectTo : '/'
			});
		} ]);
