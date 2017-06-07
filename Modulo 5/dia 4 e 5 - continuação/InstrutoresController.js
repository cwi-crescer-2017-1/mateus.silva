modulo.controller('InstrutoresController', function ($scope, instrutoresService, aulaService) {

   $scope.aulas = listAula();
   $scope.deleteClass = deleteClass;
   $scope.create = create;
   $scope.update = update;
   $scope.salvar = salvar;
   $scope.editar = editar;

   function listAula() {
       aulaService.listAula().then(function (response) {
       $scope.aulas = response.data;
     });
   }

 function salvar (instrutor){
     if  ($scope.myForm2.$invalid){
          return alert ("Nome, sobrenome idade e email são campos obrigatórios.");
     }
     if (typeof instrutor.dandoAula ==="undefined"){
          instrutor.dandoAula=false;
     }
    if (typeof instrutor.urlFoto==="undefined"){
          instrutor.urlFoto = "img/default.png";
     }
    if (typeof instrutor.id ==="number"){
          update(instrutor);
          list();
          $scope.instrutorNovo ={}
          alert("Alteração realizada com sucesso.")
     }
     else {
          create(instrutor);
          list();
          $scope.instrutorNovo ={}
     }
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
      $scope.instrutorNovo = angular.copy(instrutor);
  }

});
