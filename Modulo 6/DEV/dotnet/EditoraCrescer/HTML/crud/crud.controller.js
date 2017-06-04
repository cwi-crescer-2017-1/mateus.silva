modulo.controller ("CrudController", function ($scope, crudService, authService){

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

function revisar (livro){
  var revisor = authService.getUsuario();
  livro.DataRevisao = new Date();
  livro.Revisor.Nome = revisor.Nome;
  $scope.livro = angular.copy(livro);
}

function publicar (livro){
  console.log(livro);
  console.log(new Date().getDay);
    if (livro.DataRevisao==null){
      return alert("livro deve ser revisado");
    }
    var data = new Date();
    if (data.getDay() ===0 || data.getDay()===6){
      return alert("livro nao pode ser publicado no sabado")
    }

    livro.DataPublicacao= data;
     update(livro);}

})
