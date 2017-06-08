modulo.controller("EscolhaDoProdutoController", function ($scope, $routeParams, escolhaDoProdutoService){

var id= $routeParams.Id;
buscarClientePorId(id);
buscarPacotes();
buscarOpcionais();
$scope.selecionar = selecionar;
$scope.fazerPedido = fazerPedido;
$scope.add = add;
$scope.produtos =[];
$scope.mostrarPacotes =mostrarPacotes;
$scope.mostrarOpcionais = mostrarOpcionais;
$scope.mostrarBotaoDeFazerPedido = mostrarBotaoDeFazerPedido;
cliente = $scope.cliente;
console.log($scope.produtos.length==0);
function mostrarOpcionais(){
    if (!$scope.produtos.length==0)
    return true;
}

function mostrarPacotes (){
  if ($scope.produtos.length==0)
  return true;
}

function mostrarBotaoDeFazerPedido(){
  if ($scope.data!=undefined && mostrarOpcionais())
  return true;
}

function buscarClientePorId (id){
  escolhaDoProdutoService.buscarClientePorId(id).then(function (response){
  $scope.cliente = response.data.dado;
})};

function buscarPacotes (){
  escolhaDoProdutoService.buscarPacotes().then(function (response){
  $scope.pacotes = response.data.dado;
})};

function buscarOpcionais(){
  escolhaDoProdutoService.buscarOpcionais().then(function (response){
  $scope.opcionais= response.data.dado;
})};

function selecionar (pacote){
  $scope.produtos.push({Produto:pacote}) ;
}

function add (opcional){
  console.log($scope.data==undefined);
  $scope.produtos.push({Produto:opcional}) ;
}

function fazerPedido (){
  var  pedido = {Cliente:$scope.cliente,Itens: $scope.produtos, DataPrevistaDeEntrega: $scope.data}

   console.log(pedido);
  escolhaDoProdutoService.fazerPedido(pedido).then(function (response){
 $scope.pedido = response.data.dado;
})

}









});
