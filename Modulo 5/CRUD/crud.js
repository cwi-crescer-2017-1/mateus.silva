var modulo = angular.module ("myApp", []);


modulo.controller("mainController", function ($scope, $filter){

$scope.aulas =
{
   id: 0,
   nome: "OO"
     };
$scope.instrutores =[{
    id: 0,                            // Gerado
    nome: "Bernardo",                     // Obrigatório (length = min 3, max 20)
    sobrenome: "Rezende",           // Opcional (length = max 30)
    idade: 25,                        // Obrigatório (max 90)
    email: "bernardo@cwi.com.br",        // Obrigatório (type=email)
    dandoAula: true,                  // true ou false
    aula: [1, 4],                     // Opcional (array)
    urlFoto: "Bernardo.png"  // Opcional (porém tem uma default de livre escolha)
  }];

 $scope.todasAsAulas = [$scope.aulas];

 var operadorLogico = 1;

 function procurarPorNome () {
    return $scope.todasAsAulas.some (aula => aula.nome.toUpperCase().includes($scope.nome.toUpperCase()));
 }

$scope.incluir = function (){
   if (procurarPorNome()){
      return alert("Aula já cadastrada.");}
   if ($scope.myForm1.$valid){
      $scope.novaAula = {id:operadorLogico, nome: $scope.nome}
      $scope.todasAsAulas.push(angular.copy($scope.novaAula));
      operadorLogico++;
      $scope.novaAula = {};
}
}
$scope.list;


$scope.mudar = function (){
    var objeto =   filtrarPorNome()[0]
    objeto.nome = $scope.novoNome;
    }


function procurarAula (index) {
    return $scope.instrutores.some (instrutor => instrutor.aula.includes($scope.todasAsAulas[index].nome));
    }


function filtrarPorNome() {
     var arrayCom1objeto = $scope.todasAsAulas.filter(function(aula){ return aula.nome===$scope.list})
     return arrayCom1objeto;
}

$scope.remover= function (index){
   if (procurarAula(index)){
     return alert("Não é possível excluir esta aula. Está sendo utilizada.");
   }
  $scope.todasAsAulas.splice(index +1, 1);
  }

 var operadorLogicoInstrutor = 1;
     $scope.incluirInstrutor = function (){
     if (procurarPorInstrutor()){
        return alert("Instrutor  já cadastrado.");}
     if ($scope.myForm2.$valid){
        $scope.novoInstrutor = {id:operadorLogicoInstrutor, nome: $scope.nomeInstrutor, sobrenome: $scope.sobrenomeInstrutor,
        idade: $scope.idadeInstrutor, email:$scope.emailInstrutor, dandoAula: $scope.dandoAula, aula: $scope.aulaInstrutor, urlFoto: $scope.imgInstrutor}
        $scope.instrutores.push(angular.copy($scope.novoInstrutor));
        operadorLogicoInstrutor++;
        $scope.novoInstrutor = {};
     }
  }
  function procurarPorInstrutor () {
     return $scope.instrutores.some (instrutor=> instrutor.nome.toUpperCase().includes($scope.nomeInstrutor.toUpperCase()));
  }

    $scope.mudarInstrutor = function (){
      var objeto =   filtrarPorNomeInstrutor()[0] ;
       objeto.nome = $scope.nomeInstrutor
        objeto.sobrenome = $scope.sobrenomeInstrutor;
        objeto.idade =  $scope.idadeInstrutor;
        objeto.email = $scope.emailInstrutor;
        objeto.dandoAula = $scope.dandoAula;
        objeto.aula = $scope.aulaInstrutor;
        objeto.urlFoto = $scope.imgInstrutor;
      }

    function filtrarPorNomeInstrutor() {
         var arrayCom1objeto = $scope.instrutores.filter(function (instrutor) {return instrutor.nome===$scope.listInstrutores})
         return arrayCom1objeto;
    }

    $scope.listInstrutores;

    $scope.removerInstrutor= function (index){
      if ($scope.instrutores[index].dandoAula){
        return alert("Não é possível excluir este instrutor. Está dando aula.");
      }
       $scope.instrutores.splice(index, 1);
      }

    console.log($scope.instrutorTroca)
});
