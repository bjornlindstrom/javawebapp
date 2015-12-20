'use strict';

var stockService = angular.module('stockService', []);

stockService.factory('stockService', [function(){
	
	return {
		toggleButton: function(btn){	
			if (btn.hasAttribute('disabled')) {
				btn.removeAttribute('disabled');
			}
			else {
				btn.setAttribute('disabled', 'disabled');
			}
		}
	}
	
}]);