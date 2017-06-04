modulo.controller ("CrudController", function ($scope, crudService, authService){

  $scope.auth = authService;

listar ();
$scope.salvar = salvar;
$scope.editar = editar;
$scope.deletar = deletar;
  function listar (){
          crudService.listar().then(function(response){
            $scope.livros = response.data.dado;
  })};

  function criar (livro){
            crudService.criar(livro).then(function(response){
            listar();
  })};
  function update  (livro){
            crudService.update(livro).then(function(response){
            listar();
  })};

  function salvar (livro){

     if (typeof livro.Isbn ==="number"){
           update(livro);
      }
      else {
           criar(livro);
      }
       listar();
       $scope.livro ={}
  }

  function editar (livro) {
      $scope.livro = angular.copy(livro);
  }

  function deletar (livro){
    crudService.deletar (livro).then(function (response){
      listar();
    })
    }




})
