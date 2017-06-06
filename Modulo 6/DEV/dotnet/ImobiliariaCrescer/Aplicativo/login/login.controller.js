modulo.controller("LoginController", function ($scope, authService, toastr){
let usuario = $scope.senha;

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
