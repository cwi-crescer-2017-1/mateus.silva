modulo.controller("EscolhaDoProdutoController", function ($scope,toastr, authService, $routeParams, escolhaDoProdutoService){
$scope.logout = authService.logout;
$scope.auth = authService;

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
  if (opcional.Nome.includes("Piscina de chão") && $scope.produtos[0].Produto.Tipo.includes("Apartamento")){
     toastr.success("Opcional não está disponível para apartamentos")
  };
  $scope.produtos.push({Produto:opcional})
  buscarOpcionais(); ;
}

function fazerPedido (){
  var  pedido = {Cliente:$scope.cliente,Itens: $scope.produtos, DataPrevistaDeEntrega: $scope.data}
  escolhaDoProdutoService.fazerPedido(pedido).then(function (response){
  $scope.pedido = response.data.dado;
})};

});
