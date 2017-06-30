modulo.controller("LoginController", function ($scope, $http, loginService){

$scope.cadastrar= cadastrar;
// $scope.logar = logar;

function cadastrar(usuario){
  loginService.cadastrar(usuario).then(function(response){
  $scope.usuarioCadastrado = response.data;
 })
}

// function logar (usuario){
//   loginService.logar(usuario).then(function (response){
//     $scope.logado = response.data;
//   })
// }


});
