(function() {
	'use strict';

	var stockApp = angular.module('stockApp', [ 'ngRoute',
			'appDirectives', 'stockController',
			'stockService']);

	stockApp.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/stock', {
			templateUrl : 'components/stock/stock-list.html',
			controller : 'stockCtrl',
			controllerAs: 'vm'
		}).when('/stock/add', {
			templateUrl : 'components/stock/stock-detail.html',
			controller : 'stockDetailCtrl',
			controllerAs: 'vm'
		}).when('/stock/:stockId', {
			templateUrl : 'components/stock/stock-detail.html',
			controller : 'stockDetailCtrl',
			controllerAs: 'vm'
		}).when('/error', {
			templateUrl : 'components/error/error-list.html',
			controller : 'errorCtrl',
			controllerAs: 'vm'
		}).otherwise({
			redirectTo : '/stock'
		});
	} ])
	.config(['notificationServiceProvider', function(notificationServiceProvider) {

		notificationServiceProvider.setStack('top_left', 'stack-topleft', {
            dir1: 'down',
            dir2: 'right',
            push: 'top'
        }); 
		notificationServiceProvider.setDefaultStack('top_left');
		
		notificationServiceProvider.setDefaults({
            delay: 10000,
            buttons: {
                closer: true,
                sticker: false                
            }
        });

    }]);
}());