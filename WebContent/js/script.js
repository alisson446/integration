angular.module("listaTele", ['ngResource', 'ngRoute']).config(function ($routeProvider) {
	$routeProvider

	.when('/', {
		controller: 'listaCtrl'
	})

	.otherwise({
		redirectTo: '/'
	});

});

angular.module("listaTele").factory('Contatos', ['$resource', function ($resource) {
	return $resource('', {}, {
		lista: {
			method: 'GET',
			url: 'http://localhost:8080/integration/request/obter',
			isArray: true
		}
	});
}]);

angular.module("listaTele").controller("listaCtrl", function ($scope, Contatos) {

	Contatos.lista(function(data) {
		$scope.clientes = angular.fromJson(data);
	},function(erro) {
		console.log(erro);
	});

});

