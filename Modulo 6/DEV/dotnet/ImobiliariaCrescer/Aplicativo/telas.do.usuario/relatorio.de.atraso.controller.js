modulo.controller("RelatorioDeAtrasoController", function ($scope, authService, relatorioDeAtrasoService){
buscarRelatorio();
$scope.logout = authService.logout;
$scope.auth = authService;

function buscarRelatorio (){
  relatorioDeAtrasoService.buscarRelatorio().then(function (response){
  $scope.relatorios= response.data.dado;
})};

});
