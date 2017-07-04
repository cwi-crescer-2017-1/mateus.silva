modulo.controller("LoginController", function ($scope,  loginService, toastr, authService){

$scope.login  =login;
$scope.cadastrar= cadastrar;

function cadastrar(usuario){
  loginService.cadastrar(usuario).then(
      function (response) {
         toastr.success("Usuário cadastrado com sucesso.");
       },
      function (response) {
          toastr.error(response.data.message);
      })
      $scope.usuario ={};
}

function login (usuario){
  authService.login(usuario)
  .then(
    function (response) {
      return
    },
    function (response) {
        toastr.error("Erro no login!");
    });
 }
});
