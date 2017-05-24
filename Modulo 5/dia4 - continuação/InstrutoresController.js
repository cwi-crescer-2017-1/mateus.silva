modulo.controller('InstrutoresController', function ($scope, $routeParams, instrutoresService) {

  $scope.id = $routeParams.idUrl;

  $scope.deleteClass = deleteClass;
   $scope.create = create;
   $scope.update = update;
   $scope.salvar = salvar;
   $scope.editar = editar;

 function salvar (instrutor){
    console.log(typeof instrutor.id);
    if (typeof instrutor.id ==="number"){
       update(instrutor);
    }
    else {
        create(instrutor);
    }
    list();
   $scope.instrutorNovo ={}
 }

list();

  function create(instrutor) {
    instrutoresService.create(instrutor);
    list();
  };

//  function findById(id) {
  ///  aulaService.findById(id).then(function (response) {
  //    $scope.aula = response.data;
  //  });
//  };

  function list() {
    instrutoresService.list().then(function (response) {
      $scope.instrutores = response.data;
    });
  }

   function deleteClass(instrutor){
  instrutoresService.deleteClass(instrutor).then(function(response) {
      list();
   });
  }

  function update (instrutor){
      instrutoresService.update(instrutor).then(function () {
     list();
   })};

  function editar (instrutor) {
    $scope.instrutorNovo = angular.copy(instrutor);
  }

});
