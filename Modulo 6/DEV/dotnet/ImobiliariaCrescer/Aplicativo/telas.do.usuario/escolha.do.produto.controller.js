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
$scope.orcamento = orcamento;
$scope.mostrarBotaoDeOrcamento = mostrarBotaoDeOrcamento;
cliente = $scope.cliente;

function mostrarPacotes (){
  if ($scope.produtos.length==0)
  return true;
}

function mostrarBotaoDeOrcamento(){
  if ($scope.data!=undefined &&   $scope.mostrarOpcionais == true)
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
  $scope.mostrarOpcionais = true;
  $scope.produtos.push({Produto:pacote}) ;
}

function add (opcional){
  if (opcional.Nome.includes("Piscina de chão") && $scope.produtos[0].Produto.Tipo.includes("Apartamento")){
     toastr.success("Opcional não está disponível para apartamentos")
  };
  $scope.produtos.push({Produto:opcional})
  buscarOpcionais(); ;
}

function orcamento(){
  $scope.gerarOrcamento = true;
  $scope.mostrarOpcionais = false;
  var valor =  0;
  $scope.produtos.forEach ( p =>{ valor+=p.Produto.PrecoDaDiaria})
  $scope.valorTotal = valor*Math.ceil((Date.parse($scope.data)-Date.parse(new Date()))/(1000*3600*24));
}

function fazerPedido (){
  var  pedido = {Cliente:$scope.cliente,Itens: $scope.produtos, DataPrevistaDeEntrega: $scope.data}
  escolhaDoProdutoService.fazerPedido(pedido).then(function (response){
  $scope.pedido = response.data.dado;
})};


});
