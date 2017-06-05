modulo.controller("LoginController", function ($scope, toastr, authService){
let usuario = $scope.senha;
console.log($scope.usuario);
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
