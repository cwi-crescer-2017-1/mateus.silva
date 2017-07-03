modulo.controller("AmigosController", function ($scope, amigosService, authService){

loadAmigos();
function loadAmigos(){
  amigosService.loadAmigos().then(function (response) {
     $scope.amigos = response.data;
  } )
}
})
