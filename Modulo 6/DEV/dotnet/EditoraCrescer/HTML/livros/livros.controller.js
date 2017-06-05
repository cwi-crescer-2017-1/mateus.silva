modulo.controller("LivrosController", function ($scope, livrosService, authService, $http){

excetoLancamentos();
buscarLancamentos();
buscar();

  function excetoLancamentos(){
    livrosService.excetoLancamentos().then(function(response){
      $scope.totalItems = response.data.dado;
    })
  }

  $scope.pageChanged = function() {
  buscar ($scope.currentPage)
 };


  function buscar (page){
    if (isNaN(page) || page ===1){
      page =0;
    }
    else {
      --page;
      page = page*10;
    }
        livrosService.buscar(page).then(function(response){
        $scope.livros = response.data.dado;
        console.log($scope.livros);
})};


function buscarLancamentos (){
      livrosService.buscarLancamentos().then(function(response){
      $scope.livrosLancamentos = response.data.dado;
})};


});
