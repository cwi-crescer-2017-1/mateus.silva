var modulo = angular.module ("myApp", []);

modulo.controller("mainController", function ($scope, $filter){

$scope.aulas =
[{
   id: 0,
   nome: "OO"
 },
 {
    id: 1,
    nome: "Banco de Dados"
  },
  {
     id: 2,
     nome: "HTML"
   },
   {
      id: 3,
      nome: "JavaScript"
    },

    {
       id: 4,
       nome: "AngularJS"
     }
];
$scope.instrutores =[{
    id: 0,                            // Gerado
    nome: "Bernardo",                     // Obrigatório (length = min 3, max 20)
    sobrenome: "Rezende",           // Opcional (length = max 30)
    idade: 30,                        // Obrigatório (max 90)
    email: "bernardo@cwi.com.br",        // Obrigatório (type=email)
    dandoAula: false,                  // true ou false
    aula: [0, 3],                     // Opcional (array)
    urlFoto: "img/Bernardo.png"  // Opcional (porém tem uma default de livre escolha)
  },
  {
      id: 1,                            // Gerado
      nome: "André",                     // Obrigatório (length = min 3, max 20)
      sobrenome: "Nunes",           // Opcional (length = max 30)
      idade: 30,                        // Obrigatório (max 90)
      email: "andre@cwi.com.br",        // Obrigatório (type=email)
      dandoAula: false,                  // true ou false
      aula: [1],                     // Opcional (array)
      urlFoto: "img/nunes.png"  // Opcional (porém tem uma default de livre escolha)
    },
    {
        id: 2,                            // Gerado
        nome: "Pedro",                     // Obrigatório (length = min 3, max 20)
        sobrenome: "Henrique Pires",           // Opcional (length = max 30)
        idade: 20,                        // Obrigatório (max 90)
        email: "php@cwi.com.br",        // Obrigatório (type=email)
        dandoAula: false,                  // true ou false
        aula: [2],                     // Opcional (array)
        urlFoto: "img/php.png"  // Opcional (porém tem uma default de livre escolha)
      },
      {
          id: 3,                            // Gerado
          nome: "Everton",                     // Obrigatório (length = min 3, max 20)
          sobrenome: "Zanatta",           // Opcional (length = max 30)
          idade: 27,                        // Obrigatório (max 90)
          email: "everton@cwi.com.br",        // Obrigatório (type=email)
          dandoAula: true,                  // true ou false
          aula: [4],                     // Opcional (array)
          urlFoto: "img/zanatta.png"  // Opcional (porém tem uma default de livre escolha)
        }];

 function procurarPorNome () {
    return $scope.aulas.some (aula => aula.nome.toUpperCase().includes($scope.nome.toUpperCase()));
 }

$scope.incluir = function (){
   if (procurarPorNome()){
      return alert("Aula já cadastrada.");}
   if ($scope.myForm1.$valid){
      $scope.novaAula = {id:$scope.aulas.length, nome: $scope.nome}
      $scope.aulas.push(angular.copy($scope.novaAula));
      $scope.novaAula = {};
      alert("Inclusão realizada.")
}
}
$scope.list;


$scope.mudar = function (){
    var objeto =   filtrarPorNome()[0]
    objeto.nome = $scope.nome;
    }

function procurarAula (index) {
    return $scope.instrutores.some (instrutor => instrutor.aula.includes($scope.aulas[index].nome));
    }

function filtrarPorNome() {
     var arrayCom1objeto = $scope.aulas.filter(function(aula){ return aula.nome===$scope.list})
     return arrayCom1objeto;
}
function filtrarPorID(id) {
     var arrayCom1objeto = $scope.aulas.filter(function(aula){ return aula.id===id})
     return arrayCom1objeto;
}

$scope.remover= function (index,id){
   if (procurarAula(index)){
     return alert("Não é possível excluir esta aula. Está sendo utilizada.");
   }
   if (index === 0){
     var  array = filtrarPorID(id);
     var itemIndex = $scope.aulas.indexOf(array[0]);
      $scope.aulas.splice(itemIndex, 1);
       alert("Remoção executada com sucesso.")
   }
   else {
    $scope.aulas.splice(index, 1);
     alert("Remoção executada com sucesso.")
    }
}

 $scope.incluirInstrutor = function (){
   var b
     if (procurarPorInstrutor()){
        return alert("Instrutor  já cadastrado.");}
     if (procurarPorEmail()){
       return alert("Email já está sendo utilizado.")
     }
     if (typeof $scope.imgInstrutor==="undefined"){
       $scope.imgInstrutor = "img/Default.png";
     }
     if ($scope.aulaInstrutor[0]==="null"){
       console.log($scope.aulaInstrutor)
       $scope.aulaInstrutor= null
     }
     if  ($scope.myForm2.$valid){
        $scope.novoInstrutor = {id:$scope.instrutores.length, nome: $scope.nomeInstrutor, sobrenome: $scope.sobrenomeInstrutor,
        idade: $scope.idadeInstrutor, email:$scope.emailInstrutor, dandoAula: $scope.dandoAula, aula:  $scope.aulaInstrutor, urlFoto: $scope.imgInstrutor}
        $scope.instrutores.push(angular.copy($scope.novoInstrutor));
        $scope.novoInstrutor = {};
        alert("Inclusão realizada.")

     }
     }
  function procurarPorInstrutor () {
     return $scope.instrutores.some (instrutor=> instrutor.nome.toUpperCase().includes($scope.nomeInstrutor.toUpperCase()));
  }
  function procurarPorEmail () {
     return $scope.instrutores.some (instrutor=> instrutor.email.toUpperCase().includes($scope.emailInstrutor.toUpperCase()));
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
       alert("Alteração realizada.")

      }

    function filtrarPorNomeInstrutor() {
         var arrayCom1objeto = $scope.instrutores.filter(function (instrutor) {return instrutor.nome===$scope.listInstrutores})
         return arrayCom1objeto;
    }

    $scope.listInstrutores;

$scope.removerInstrutor= function (index, id){
     var  array = filtrarPorIDInstrutor(id);
     var itemIndex = $scope.instrutores.indexOf(array[0]);
     if ($scope.instrutores[itemIndex].dandoAula){
           return alert("Não é possível excluir este instrutor. Está dando aula.");
    }
    else {   $scope.instrutores.splice(itemIndex, 1)}
       }

  function filtrarPorIDInstrutor(id) {
       var arrayCom1objeto = $scope.instrutores.filter(function(instrutor){ return instrutor.id===id})
       return arrayCom1objeto;
  }
    console.log($scope.aulas)
});
