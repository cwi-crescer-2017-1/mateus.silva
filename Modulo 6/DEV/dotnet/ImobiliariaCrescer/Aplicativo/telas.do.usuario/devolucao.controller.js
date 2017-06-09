modulo.controller("DevolucaoController", function ($scope, $routeParams, devolucaoService){

buscarPedidos();
$scope.selecionar = selecionar;
$scope.colocarDataDeEntrega = colocarDataDeEntrega;

function selecionar (pedido){
  return  $scope.pedidoSelecionado = pedido;
}

function colocarDataDeEntrega (pedido){
  devolucaoService.colocarDataDeEntrega(pedido).then(function (response){
  buscarPedidos();
})};

function buscarPedidos (){
  devolucaoService.buscarPedidos().then(function (response){
  $scope.pedidos=  response.data.dado;
  })
}

});
