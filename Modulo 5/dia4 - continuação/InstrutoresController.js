modulo.controller('InstrutoresController', function ($scope, $routeParams, instrutoresService, aulaService) {

  $scope.id = $routeParams.idUrl;

  $scope.deleteClass = deleteClass;
   $scope.create = create;
   $scope.update = update;
   $scope.salvar = salvar;
   $scope.editar = editar;

 function salvar (instrutor){
    if (typeof instrutor.urlFoto==="undefined"){
      $scope.instrutorNovo.img = "img/default.png";
    }
    if (typeof instrutor.id ==="number"){
       update(instrutor);
       alert("Alteração realizada com sucesso.")
        $scope.instrutorNovo ={}
      }
     else {  if  ($scope.myForm2.$valid){
                     create(instrutor);
                     $scope.instrutorNovo ={}
        }
            else { alert ("É necessário preencher os campos obrigatórios.")}
     }
  list();
 }

list();

  function create(instrutor) {
    instrutoresService.create(instrutor).then (function (response){
    list();})
  };


  function list() {
    instrutoresService.list().then(function (response) {
      $scope.instrutores = response.data;
    });
  }

   function deleteClass(instrutor){
  instrutoresService.deleteClass(instrutor).then(function(response) {
      list();
      alert("Remoção realizada com sucesso.")

   });
  }

  function update (instrutor){
      instrutoresService.update(instrutor).then(function (response) {
     list();
   })};

  function editar (instrutor) {
      console.log($scope.aulas);
    $scope.instrutorNovo = angular.copy(instrutor);
  }

});
