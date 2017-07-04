modulo.controller("LoginController", function ($scope,  loginService, toastr, authService){

$scope.login  =login;
$scope.cadastrar= cadastrar;

function cadastrar(usuario){
  loginService.cadastrar(usuario).then(
      function (response) {
         toastr.success("Cadastro feito com sucesso.");
       },
      function (response) {
          toastr.error("Usuário já existe.");
      })
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
