modulo.controller("EscolhaDoProdutoController", function ($scope, $routeParams, escolhaDoProdutoService){

var id= $routeParams.Id;
buscarClientePorId(id);
buscarPacotes();
buscarOpcionais();



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
});
