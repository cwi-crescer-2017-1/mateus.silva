modulo.controller("RelatorioDeAtrasoController", function ($scope, relatorioDeAtrasoService){
buscarRelatorio();

  function buscarRelatorio (){
    relatorioDeAtrasoService.buscarRelatorio().then(function (response){
        $scope.relatorios= response.data.dado;
    })};

});
