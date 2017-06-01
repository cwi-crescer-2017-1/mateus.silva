modulo.controller("homePageController", function ($scope, service){
buscarLancamentos();
console.log($scope.livros);


function buscarLancamentos (){
      service.buscarLancamentos().then(function(response){
      $scope.livros = response.data;
    })};


});
