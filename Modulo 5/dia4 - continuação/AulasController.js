var modulo = angular.module ("myApp", ["ngRoute"]);

modulo.config(function($routeProvider){
     $routeProvider
     .when ("/aula", {
       templateUrl: "aula.html", controller: "AulaController"})
      .when ("/instrutores", {
      templateUrl: "instrutores.html", controller:"InstrutoresController"}).otherwise({redirectTo:"/index"})
});

modulo.controller('AulaController', function ($scope, $routeParams, aulaService) {

  $scope.id = $routeParams.idUrl;

  $scope.deleteClass = deleteClass;
  $scope.create = create;
  $scope.update = update;
  $scope.salvar = salvar;
  $scope.editar = editar;

  function salvar (aula){
    if (typeof aula.id ==="number"){
       update(aula);
       alert("Alteração realizada com sucesso.")
    }
    else
      {  if  ($scope.myForm1.$valid){
                create(instrutor);
                $scope.instrutorNovo ={}
                 alert("Inclusão realizada com sucesso.")
        }
        else { alert ("É necessário preencher o nome da aula.")}
     }
    list();
    $scope.aulaNova ={}
  }

list();

  function create(aula) {
    aulaService.create(aula).then (function (response){
    list();})
  };


  function list() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
    });
  }

    function deleteClass(aula){
    aulaService.deleteClass(aula).then(function(response) {
      list();
      alert("Remoção realizada com sucesso.")

    });
  }

   function update (aula){
     aulaService.update(aula).then(function (response) {
        list();
   })};

  function editar (aula) {
    $scope.aulaNova = angular.copy(aula);
  }

});
