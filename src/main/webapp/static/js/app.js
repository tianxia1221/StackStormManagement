'use strict';

var App = angular.module('myApp', [ 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : 'static/html/home.html'
			}).when('/actions', {
				templateUrl : 'static/html/actions.html'
			}).when('/action', {
				templateUrl : 'static/html/action.html'
			}).when('/executions', {
				templateUrl : 'static/html/executions.html'
			}).when('/execution', {
				templateUrl : 'static/html/execution.html'
			}).when('/inquiries', {
				templateUrl : 'static/html/inquiries.html'
			}).when('/inquiry', {
				templateUrl : 'static/html/inquiry.html'
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
