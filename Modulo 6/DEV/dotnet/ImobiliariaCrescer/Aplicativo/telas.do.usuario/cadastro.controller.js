modulo.controller("cadastroController", function ($scope, toastr, authService, cadastroService){
  $scope.cliente;
  $scope.logout = authService.logout;
  $scope.auth = authService;
  $scope.cadastrar = cadastrar;

  function cadastrar (cliente){
    cadastroService.cadastrar(cliente).then(function (response){
        toastr.success("Cliente cadastrado com sucesso.")
        $scope.cliente ={};
    })};



});
