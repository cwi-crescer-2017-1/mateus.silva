modulo.controller("DevolucaoController", function ($scope, $routeParams, devolucaoService){

buscarPedidos();
//$scope.devolver = devolver;
$scope.selecionar = selecionar;
$scope.colocarDataDeEntrega = colocarDataDeEntrega;
function selecionar (pedido){
  return  $scope.pedidoSelecionado = pedido;
}

//function devolver (pedido){
//  console.log(pedido);
//  colocarDataDeEntrega(pedido);
//  devolucaoService.devolver(pedido).then(function (reponse){
//  alert ("ok");
//})};

function colocarDataDeEntrega (pedido){
  console.log(pedido);
  devolucaoService.colocarDataDeEntrega(pedido).then(function (response){
  alert ("ok");
})};

function buscarPedidos (){
  devolucaoService.buscarPedidos().then(function (response){
  $scope.pedidos=  response.data.dado;
  console.log(  $scope.pedidos);
  })
}

});
