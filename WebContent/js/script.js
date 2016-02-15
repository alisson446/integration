angular.module("listaTele", ['ngResource', 'ngRoute']);

angular.module("listaTele").factory('Contatos',	['$resource', function($resource) {
	return $resource('', {}, {
		todos : {
			method : 'GET',
			url : 'http://localhost:8080/integration/index/todos',
			isArray : true
		},
		salvar : {
			method : 'POST',
			url : 'http://localhost:8080/integration/index/salvar/:fluxoparams',
			params: {fluxoparams: '@fluxo'},
			isArray : true
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
		$scope.caixa = null;
		if(screen == 'cadastrar') {
			$scope.titleModal = 'Adicionar';
		}else if(screen == 'editar'){
			$scope.titleModal = 'Editar';
			exibirEdicao(codFluxo);
		}else {
			$scope.fluxoSelecionado =codFluxo; 
		}
	};
	
	$scope.showIcon = function(coluna) {
		$scope.codigoIcon = false;
		$scope.descricaoIcon = false;
		$scope.tipoIcon = false;
		$scope.classeIcon = false;
		$scope.statusIcon = false;
		
		switch(coluna) {
			case 'codigo':
				$scope.codigoIcon = true;
				break;
			case 'descricao':
				$scope.descricaoIcon = true;
				break;
			case 'tipo':
				$scope.tipoIcon = true;
				break;
			case 'classe':
				$scope.classeIcon = true;
				break;
			case 'status':
				$scope.statusIcon = true;
				break;
			default:
				break;
		}
		
		if($scope.iconOrder == true) {
			$scope.icon = 'fa fa-arrow-down';
		}else {
			$scope.icon = 'fa fa-arrow-up';
		}
	}

	$scope.salvar = function(fc, valid) {
		Contatos.salvar({fluxo: fc}, function(data) {
			$scope.fluxos = angular.fromJson(data);
		});
	};

	var exibirEdicao = function(codFluxo, confirm) {
		Contatos.fluxoSelected({cod: codFluxo}, function(data) {
			$scope.caixa = angular.fromJson(data);
		});
	};
	
	$scope.deletar = function(codApagar){
		Contatos.excluir({codigoflux: codApagar}, function (data) {
			$scope.fluxos = angular.fromJson(data);
		});
	};
	
	$scope.ordenarPor = function (campo) {
		$scope.criterio = campo;
		$scope.direcao = !$scope.direcao;
	};

});
