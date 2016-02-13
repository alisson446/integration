angular.module("listaTele", ['ngResource', 'ngRoute']).config(
		function($routeProvider) {
			$routeProvider.when('/', {
				controller : 'listaCtrl'
			});

		});

angular.module("listaTele").factory('Contatos',	['$resource', function($resource) {
	return $resource('', {}, {
		todos : {
			method : 'GET',
			url : 'http://localhost:8080/integration/index/todos',
			isArray : true
		},
		save : {
			method : 'POST',
			url : 'http://localhost:8080/integration/index/salvar/:fluxoparams',
			params: {fluxoparams: '@fluxo'}
		},
		fluxoSelected : {
			method : 'POST',
			url : 'http://localhost:8080/integration/index/exibir/:codigoFluxo',
			params: {codigoFluxo: '@cod'},
		},
		excluir : {
			method : 'POST',
			url : 'http://localhost:8080/integration/index/excluir/:fluxocod',
			params : {fluxocod: '@codigoflux'},
			isArray : true
		}
	});
} ]);

angular.module("listaTele").controller("listaCtrl", function($scope, Contatos) {

	Contatos.todos(function(data) {
		$scope.fluxos = angular.fromJson(data);
	}, function(erro) {
		$scope.fluxos = null;
		console.log(erro);
	});

	$scope.show = function(screen, codFluxo) {
		if(screen == 'cadastrar') {
			$scope.titleModal = 'Adicionar';
		}else {
			$scope.titleModal = 'Editar';
			exibirEdicao(codFluxo);
		}
	};

	$scope.salvar = function(fc) {
		Contatos.save({fluxo: fc}, function() {
			$scope.caixa = null;
		});
	};
	
	$scope.deletar = function(cdgFluxo){
		var apagar = cdgFluxo;
		Contatos.excluir({codigoflux:apagar}, function (data) {
			$scope.fluxos = angular.fromJson(data);
		});
	};

	var exibirEdicao = function(codFluxo) {
		Contatos.fluxoSelected({cod: codFluxo}, function(data) {
			$scope.caixa = angular.fromJson(data);
		});
	};

}]);
