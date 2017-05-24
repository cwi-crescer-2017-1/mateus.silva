var modulo = angular.module ("myApp", ["ngRoute"]);

modulo.config(function($routeProvider){
     $routeProvider
     .when ("/aula", {
       templateUrl: "aula.html", controller: "AulaController"})
      .when ("/instrutores", {
      templateUrl: "instrutores.html", controller:"InstrutoresController"}).otherwise({redirectTo:"/menu"})
});

modulo.controller('AulaController', function ($scope, $routeParams, aulaService) {

  $scope.id = $routeParams.idUrl;

  $scope.deleteClass = deleteClass;
  $scope.create = create;
  $scope.update = update;
  $scope.salvar = salvar;
  $scope.editar = editar;

  function salvar (aula){
    console.log(typeof aula.id);
    if (typeof aula.id ==="number"){
       update(aula);
    }
    else {
        create(aula);
    }
    list();
    $scope.aulaNova ={}
  }

list();

  function create(aula) {
    aulaService.create(aula);
    list();
  };

  function findById(id) {
    aulaService.findById(id).then(function (response) {
      $scope.aula = response.data;
    });
  };

  function list() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
    });
  }

    function deleteClass(aula){
    aulaService.deleteClass(aula).then(function(response) {
      list();
    });
  }

   function update (aula){
     aulaService.update(aula).then(function () {
        list();
   })};

  function editar (aula) {
    $scope.aulaNova = angular.copy(aula);
  }

});
