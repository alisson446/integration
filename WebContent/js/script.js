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
		save : {
			method : 'POST',
			url : 'http://localhost:8080/integration/index/salvar/:fluxo2',
			params: {fluxo2: '@fluxo'}
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

	Contatos.todos(function(data) {
		$scope.fluxos = angular.fromJson(data);
	}, function(erro) {
		$scope.fluxos = null;
		console.log(erro);
	});

	$scope.salvar = function(fluxo) {
		var fc = fluxo;
		Contatos.save({fluxo: fc}, function(erro) {
			$scope.caixa = null;
			console.log(erro);
		});
	};

});