modulo.controller("InformaOClienteController", function ($scope, authService, informaOUsuarioService){
  $scope.logout = authService.logout;
  $scope.auth = authService;
listarClientes();

function listarClientes (){
  informaOUsuarioService.listarClientes().then(function (response){
  $scope.clientes= response.data.dado;
  })};


});
