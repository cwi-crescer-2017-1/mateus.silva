var modulo = angular.module ("myApp", []);


modulo.controller("mainController", function ($scope, $filter){

$scope.aulas =
{
   id: 0,
   nome: "OO"
     };

 $scope.todasAsAulas = [$scope.aulas];

 var operadorLogico = 1;

 function procurarPorNome () {
   return $scope.todasAsAulas.some (aula => aula.nome.includes($scope.nome));
 }

$scope.incluir = function (){
   if (procurarPorNome()){
      return;}
  $scope.novaAula = {id:operadorLogico, nome: $scope.nome}
  $scope.todasAsAulas.push(angular.copy($scope.novaAula));
  operadorLogico++;
  $scope.novaAula = {};
}
$scope.list;

$scope.mudar = function (){
      filtrarPorNome()[0].nome = $scope.nome;
      console.log(filtrarPorNome()[0].nome)
}

function filtrarPorNome() {
       var arrayCom1objeto = $scope.todasAsAulas.filter(function(aula){ return aula.nome===$scope.list})
       return arrayCom1objeto;
}
console.log($scope.todasAsAulas)

});
