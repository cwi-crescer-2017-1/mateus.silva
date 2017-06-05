modulo.controller("LivrosController", function ($scope, livrosService, authService, $http){
sohLancamentos();
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
})};

function sohLancamentos(){
  livrosService.sohLancamentos().then(function(response){
    $scope.totalItemsLancamentos = response.data.dado;
    console.log(  $scope.totalItemsLancamentos);
  })
}

$scope.pageChangedLancamentos = function() {
buscarLancamentos ($scope.currentPageLancamentos)
};


function buscarLancamentos (pageL){
  if (isNaN(pageL) || pageL ===1){
    pageL =0;
  }
  else {
    --pageL;

  }
      livrosService.buscarLancamentos(pageL).then(function(response){
      $scope.livrosLancamentos = response.data.dado;
})};

});
