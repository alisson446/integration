angular.module("listaTele", [ 'ngResource', 'ngRoute' ]).config(
		function($routeProvider) {
			$routeProvider.when('/', {
				controller : 'listaCtrl'
			});

		});

angular.module("listaTele").factory('Contatos',	[ '$resource', function($resource) {
			return $resource('', {}, {
				lista : {
					method : 'GET',
					url : 'http://localhost:8089/integration/request/obter',
					isArray : true
				},
				salvar : {
					method : 'POST',
					url : '#',
					isArray : true
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

	Contatos.lista(function(data) {
		$scope.clientes = angular.fromJson(data);
	}, function(erro) {
		console.log(erro);
	});

	$scope.salvar = function() {
		Contatos.salvar(function() {
			
		}, function(erro) {
			console.log(erro);
		});
	};

});