modulo.controller("cadastroController", function ($scope, toastr,  cadastroService){
  $scope.cliente;

  $scope.cadastrar = cadastrar;

  function cadastrar (cliente){
    cadastroService.cadastrar(cliente).then(function (response){
        toastr.success("Cliente cadastrado com sucesso.")
    })};



});
