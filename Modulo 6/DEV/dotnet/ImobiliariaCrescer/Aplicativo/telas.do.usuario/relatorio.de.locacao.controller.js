modulo.controller("RelatorioDeLocacaoController", function ($scope, relatorioDeLocacaoService){
buscarRelatorio();

  function buscarRelatorio (){
    relatorioDeLocacaoService.buscarRelatorio().then(function (response){
        $scope.relatorios= response.data.dado;
    })};

});
