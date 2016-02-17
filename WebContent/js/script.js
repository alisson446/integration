angular.module("listaTele", ['ngResource']);

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
	}, function() {
		$scope.fluxos = null;
	});

	$scope.show = function(screen, codFluxo) {
		$scope.caixa = null;
		$scope.validacao = false;
		if(screen == 'cadastrar') {
			$scope.disableCod = false;
			$scope.titleModal = 'Adicionar';
		}else if(screen == 'editar'){
			$scope.disableCod = true;
			$scope.titleModal = 'Editar';
			exibirEdicao(codFluxo);
		}else {
			$scope.fluxoSelecionado = codFluxo; 
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
			$scope.icon = 'arrow-down.png';
		}else {
			$scope.icon = 'arrow-up.png';
		}
	}

	$scope.salvar = function(fc) {
		Contatos.salvar({fluxo: fc}, function(data) {
			$scope.fluxos = angular.fromJson(data);
		});
	};
	
	$scope.$watch('caixa.codigoFluxo', function(newValue, oldValue) {
		if($scope.disableCod==false && newValue!=undefined) {
			var todosFluxos = $scope.fluxos;
			for(var i=0; i<=todosFluxos.length-1;i++){
				if($scope.caixa.codigoFluxo.toString() == todosFluxos[i].codigoFluxo.toString()) {
					$scope.validacao = true;
					return false; 
				}
			}
		}
		$scope.validacao = false;
		return true;
	});

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



