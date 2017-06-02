modulo.controller("LivrosController", function ($scope, livrosService, $http){

buscarLancamentos();
buscarTodosOsLivros ();
$scope.buscar = buscar;



function buscarLancamentos (){
      livrosService.buscarLancamentos().then(function(response){
      $scope.livrosLancamentos = response.data.dado;
    })};


function buscarTodosOsLivros (){
          livrosService.buscarTodosOsLivros().then(function(response){
          $scope.livros = response.data.dado;
        })};


function buscar (parametros){
      livrosService.buscar(parametros).then(function(response){
        $scope.livros = response.data.dado;
    })};


});
