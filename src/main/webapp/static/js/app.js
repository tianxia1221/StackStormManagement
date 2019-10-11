'use strict';

var App = angular.module('myApp', [ 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				template : 'this is home'
			}).when('/actions', {
				templateUrl : 'static/html/actions.html'
			}).when('/action', {
				templateUrl : 'static/html/action.html'
			}).when('oneaction', {
		        templateUrl: 'StackStormManagement/OneActionManagement.jsp',
		        controller: 'OneActionController'
			}).when('/printers', {
				templateUrl : 'static/html/a.html'
			}).when('/b', {
				templateUrl : 'static/html/b.html'
			}).when('/test', {
				templateUrl : 'static/html/test.html'
			}).otherwise({
				redirectTo : '/'
			});
		} ]);
