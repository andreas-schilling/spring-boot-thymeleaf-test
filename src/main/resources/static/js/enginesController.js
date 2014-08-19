var enginesModule = angular.module('enginesModule', [ 'ngGrid' ]);

enginesModule.controller('enginesListCtrl', function($scope, $http) {
	$http.get('/engines/all.json').success(function(data) {
		$scope.engines = data;
	});
	$scope.gridOptions = {
		data : 'engines',
		enableRowSelection: false,
        enableCellEditOnFocus: true,
        multiSelect: false,
        jqueryUIDraggable: true,
        columnDefs: [
          { field: 'id', displayName: 'ID', enableCellEdit: false } ,
          { field: 'label', displayName: 'Engine', enableCellEdit: true }
        ]
	};
});
