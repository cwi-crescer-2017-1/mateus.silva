modulo.controller("LoginController", function ($scope, $http, loginService){

$scope.cadastrar= cadastrar;

function cadastrar(usuario){
  console.log(usuario);
  loginService.cadastrar(usuario).then(function(response){
    console.log(response);
  $scope.usuarioCadastrado = response.data;
})
}



});
