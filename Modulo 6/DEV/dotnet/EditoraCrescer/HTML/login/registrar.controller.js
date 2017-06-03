modulo.controller("RegistrarController", function ($scope, $http, registrarService){

$scope.registrar = registrar;
let  novoUsuario = $scope.novoUsuario;

function registrar (novoUsuario){
console.log(novoUsuario);
  registrarService.registrar (novoUsuario).then(function (response){

      $scope.usuarioRegistrado = response.data.dado;
  }) }


});
