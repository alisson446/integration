angular.module("listaTele", [ 'ngResource', 'ngRoute' ]).config(
		function($routeProvider) {
			$routeProvider.when('/', {
				controller : 'listaCtrl'
			});

		});

angular.module("listaTele").factory('Contatos',	[ '$resource', function($resource) {
			return $resource('', {}, {
				todos : {
					method : 'GET',
					url : 'http://localhost:8080/integration/index/todos',
					isArray : true
				},
				salvar : {
					method : 'POST',
					url : 'http://localhost:8080/integration/index/salvar/:caixa',
					params: {caixa: '@caixa'},	
					isArray: true
				},
				excluir : {
					method : 'GET',
					url : '#',
					isArray : true
				},
				fluxoSelected : {
					method : 'GET',
					url : '#',
					isArray : true
				}
			});
		} ]);

angular.module("listaTele").controller("listaCtrl", function($scope, Contatos) {

	$scope.caixa = {};
	
	/*Contatos.todos(function(data) {
		$scope.fluxos = angular.fromJson(data);
	}, function(erro) {
		$scope.fluxos = null;
		console.log(erro);
	});*/

	$scope.salvar = function(caixa) {
		Contatos.salvar({caixa:caixa}, function(erro) {
			$scope.caixa = null;
			console.log(erro);
		});
	};

});