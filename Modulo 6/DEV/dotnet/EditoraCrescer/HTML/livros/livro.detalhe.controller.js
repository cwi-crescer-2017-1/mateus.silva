modulo.controller("LivroDetalheController", function ($scope, $routeParams, livroDetalheService){

var isbn= $routeParams.isbn;
buscarPorId (isbn);

function buscarPorId (isbn){
  livroDetalheService.buscarPorId(isbn).then(function (response){
    $scope.detalheLivro = response.data;
  })};

});
