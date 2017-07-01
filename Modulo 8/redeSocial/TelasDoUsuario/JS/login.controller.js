modulo.controller("LoginController", function ($scope,  loginService, toastr, authService){

$scope.cadastrar= cadastrar;
function cadastrar(usuario){
  loginService.cadastrar(usuario).then(function(response){
  $scope.usuarioCadastrado = response.data;
 })
}

$scope.login  =login;
function login (usuario){

  authService.login(usuario)
     .then(
      function (response) {
  toastr.success("Login executado com sucesso.")
       },
       function (response) {
       toastr.error("Erro no login!");
      });
}
});
