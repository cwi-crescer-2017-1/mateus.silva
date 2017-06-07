modulo.controller("EscolhaDoProdutoController", function ($scope, $routeParams, escolhaDoProdutoService){

var id= $routeParams.Id;
buscarClientePorId(id);
buscarPacotes();
buscarOpcionais();
$scope.fazerPedido = fazerPedido;
cliente = $scope.cliente;
console.log(cliente);


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

function fazerPedido (){
        escolhaDoProdutoService.fazerPedido().then(function (response){
          $scope.pedido = response.data.dado;
    })





}



});
