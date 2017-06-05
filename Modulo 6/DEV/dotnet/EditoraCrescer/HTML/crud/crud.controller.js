modulo.controller ("CrudController", function ($scope, toastr, crudService, authService){

$scope.auth = authService;
$scope.logout = authService.logout;
listar ();
$scope.salvar = salvar;
$scope.editar = editar;
$scope.deletar = deletar;
$scope.revisar = revisar;
$scope.publicar = publicar;

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
            toastr.success("Atualização executada com sucesso");
      }
      else {
           criar(livro);
           toastr.success("Livro criado com sucesso");
      }
       listar();
       $scope.livro ={}
  }

  function editar (livro) {
      $scope.livro = angular.copy(livro);
  }

  function deletar (livro){
    crudService.deletar (livro).then(function (response){
        toastr.success("Exclusão realizada  com sucesso");
      listar();
    })
    }

function revisar (livro){
  var revisor = authService.getUsuario();
  livro.DataRevisao = new Date();
  livro.Revisor.Nome = revisor.Nome;
  $scope.livro = angular.copy(livro);
}

function publicar (livro){
    if (livro.DataRevisao==null){
       return toastr.warning("O livro deve ser revisado antes da publicação.");
    }
    var data = new Date();
    if (data.getDay() ===0 || data.getDay()===6){
      return toastr.error("As publicações não podem ocorrer no final de semana.");
    }
    livro.DataPublicacao= data;
     toastr.success("Publicação realizada  com sucesso");
    update(livro);
  }

})
