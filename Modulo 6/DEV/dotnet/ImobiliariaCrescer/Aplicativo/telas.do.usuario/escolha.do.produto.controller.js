modulo.controller("EscolhaDoProdutoController", function ($scope, $routeParams, escolhaDoProdutoService){

var id= $routeParams.Id;
buscarClientePorId(id);

function buscarClientePorId (id){
    escolhaDoProdutoService.buscarClientePorId(id).then(function (response){
    $scope.cliente = response.data.dado;
  })};


});
