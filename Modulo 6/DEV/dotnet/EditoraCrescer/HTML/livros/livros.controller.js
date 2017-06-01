modulo.controller("LivrosController", function ($scope, livrosService){
buscarLancamentos();
buscarTodosOsLivros ();
console.log($scope.livros);


function buscarLancamentos (){
      livrosService.buscarLancamentos().then(function(response){
      $scope.livros = response.data;
    })};


    function buscarTodosOsLivros (){
          livrosService.buscarTodosOsLivros().then(function(response){
          $scope.livrosTodos = response.data;
        })};



});
