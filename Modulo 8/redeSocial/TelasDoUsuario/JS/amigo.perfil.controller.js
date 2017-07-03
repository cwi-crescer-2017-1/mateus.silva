modulo.controller("amigoPerfilController", function ($scope, $routeParams, amigosService, authService){
var amigoId= $routeParams.id;
loadAmigoPerfil(amigoId);
loadAmigoPosts(amigoId);

function loadAmigoPerfil(amigoId){
  amigosService.loadAmigoPerfil(amigoId).then(function (response) {
     $scope.amigoPerfil = response.data;
  } )
}

function loadAmigoPosts(amigoId){
  amigosService.loadAmigoPosts(amigoId).then(function (response) {
     $scope.amigoPosts = response.data;
     console.log($scope.amigoPosts );
  } )
}

})
