'use strict';

var stockController = angular.module('stockController', ['stockService']);

stockController.controller('stockCtrl', ['$scope', '$http', 'notificationService', 
  function ($scope, $http, notificationService) {
    
	$scope.itemsPerPage = 10;

	$scope.initPage = function(data){
		if(data){
			$scope.totalItems = $scope.data.totalElements;
			// backend paging is 0 based.
			$scope.currentPage = $scope.data.number+1;
			$scope.numPages = $scope.data.totalPages;
		}
	}
	
	$scope.selectPage = function() {		
		$http.get('/api/stock?page='+($scope.currentPage > 0 ? $scope.currentPage-1 : 0)+'&sort=id,asc&size='+$scope.itemsPerPage)
		.success(function(data) {
			$scope.data = data;		      
			$scope.initPage(data);	
		});
	};
	
	$scope.selectPage(0);    	
	
  }]);

stockController.controller('stockDetailCtrl', ['$scope', '$http', '$routeParams', 'stockService', 'notificationService', 
  function($scope, $http, $routeParams, stockService, notificationService) {
	var vm = this;
	
	if ($routeParams.stockId) {
		$http.get('/stock/'+$routeParams.stockId)
		.success(function(data) {
		      $scope.stock = data;
		      $scope.stockId = $routeParams.stockId;
		})
		.error(function(data){
			notificationService.error("Could not get the stock: " + (data ? data.message : ''));
		});
	}
	
	$scope.savestock = function(event){
		stockService.toggleButton(event.target);
		
		var saveSuccess = function(){
			notificationService.success("Saved stock successfully.");
	        stockService.toggleButton(event.target);
	    };
	    var saveError = function(data){
        	notificationService.error("Save stock failed: " + (data ? data.message : ''));
        	stockService.toggleButton(event.target);	        
	    };
		
		if ($scope.stock.id){
			$http.put('/stock', $scope.stock)
	        .success(saveSuccess)
	        .error(saveError);
		} else {
			$http.post('/stock', $scope.stock)
	        .success(saveSuccess)
	        .error(saveError);
		}		
	};
}])


