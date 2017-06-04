modulo.controller("LoginController", function ($scope, authService){
let usuario = $scope.senha;
console.log($scope.usuario);
$scope.login  =login;


function login (usuario){

  authService.login(usuario)
    .then(
      function (response) {
        console.log(usuario);
        console.log(response);
        alert('Login com sucesso!');

      },
      function (response) {
        console.log(response);
        alert('Erro no Login!');
      });
}

});
