modulo.controller("RelatorioDeLocacaoController", function ($scope, authService, relatorioDeLocacaoService){
buscarRelatorio();
buscarSoma();
$scope.logout = authService.logout;
$scope.auth = authService;

function buscarRelatorio (){
  relatorioDeLocacaoService.buscarRelatorio().then(function (response){
  $scope.relatorios= response.data.dado;
})};


function buscarSoma (){
  relatorioDeLocacaoService.buscarSoma().then(function (response){
  $scope.soma= response.data.dado;
})};
});
