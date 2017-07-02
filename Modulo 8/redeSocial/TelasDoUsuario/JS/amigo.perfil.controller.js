modulo.controller("amigoPerfilController", function ($scope, $routeParams, amigosService, authService){
var amigoId= $routeParams.id;
loadAmigoPerfil(amigoId);


function loadAmigoPerfil(amigoId){
  amigosService.loadAmigoPerfil(amigoId).then(function (response) {
     $scope.amigoPerfil = response.data;
  } )
}

})
