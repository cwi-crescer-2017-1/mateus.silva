modulo.controller('AulaController', function ($scope, aulaService) {

  $scope.deleteAula = deleteAula;
  $scope.createAula = createAula;
  $scope.updateAula = updateAula;
  $scope.salvarAula = salvarAula;
  $scope.editarAula = editarAula;

  function salvarAula (aula){
    if  ($scope.myForm1.$invalid){
            return alert ("É necessário preencher o nome da aula.");
    }
    if (typeof aula.id ==="number"){
           updateAula(aula);
           $scope.aulaNova ={};
           listAula();
       alert("Alteração realizada com sucesso.")
    }
    else  {
          createAula(aula);
          $scope.aulaNova ={};
          listAula();
          alert("Inclusão realizada com sucesso.")
  }
}

listAula();

  function createAula(aula) {
       aulaService.createAula(aula).then (function (response){
       listAula();})
  };


  function listAula() {
       aulaService.listAula().then(function (response) {
       $scope.aulas = response.data;
    });
  }

    function deleteAula(aula){
        aulaService.deleteAula(aula).then(function(response) {
        listAula();
        alert("Remoção realizada com sucesso.")

    });
  }

   function updateAula (aula){
        aulaService.updateAula(aula).then(function (response) {
        listAula();
   })};

  function editarAula (aula) {
        $scope.aulaNova = angular.copy(aula);
  }

});
