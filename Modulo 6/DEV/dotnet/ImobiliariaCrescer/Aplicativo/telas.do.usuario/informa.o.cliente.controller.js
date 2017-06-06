modulo.controller("InformaOClienteController", function ($scope, authService, informaOUsuarioService){

listarClientes();

function listarClientes (){
  informaOUsuarioService.listarClientes().then(function (response){
   $scope.clientes= response.data.dado;
  })};




});
