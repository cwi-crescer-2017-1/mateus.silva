var modulo = angular.module ("myApp", ["ngRoute"]);

modulo.config(function($routeProvider){
     $routeProvider
     .when ("/aula", {
       templateUrl: "aula.html", controller: "AulaController"})
      .when ("/instrutores", {
      templateUrl: "instrutores.html", controller:"InstrutoresController"}).otherwise({redirectTo:"/menu"})
});

modulo.controller('AulaController', function ($scope, $routeParams, aulaService) {
  //modulo.controller('AulaController', function ($scope, aulaService) {

  $scope.id = $routeParams.idUrl;

  // ações de click
 $scope.deleteClass = deleteClass;
  $scope.create = create;
  $scope.update = update;
  console.log($scope.delete);
 $scope.aulaNova = { };
//  findById($scope.id); // buscar aula por id (passado na url)
  list(); // listar aulas

  // Funções internas

  function create(aula) {
    aulaService.create(aula);
    list();
  };

  function findById(id) {
    aulaService.findById(id).then(function (response) {
      $scope.aula = response.data;
      // ver i o que está retornando
    });
  };

  function list() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
      console.log($scope.aulas)
    });
  }

    function deleteClass(aula){
    aulaService.deleteClass(aula).then(function(response) {
      list();
    });
  }

  function update(aula) {
    $scope.aulaNova = angular.copy(aula) ;
    console.log(aula);
    // aulaService.update(aula).then(function () {
    //   list();
    // });
  }
// angular.copy(aula) para nao aperecer na tela

});
  /*


  modulo.controller("AulasController", function ($scope){
   $scope.controller = "ooooooi"
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
      if (typeof $scope.nome === "undefined"){
        alert ("É necessário preencher o nome da aula para incluir aula.")
      }
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
      if (typeof $scope.nome==="undefined"){
         return alert("É necessário incluir um nome válido para alterar o nome.")
       }
      if (procurarPorNome()){
         return alert("Aula já cadastrada.");}

        var objeto =   filtrarPorNome()[0]
       objeto.nome = $scope.nome;
    }

    function procurarAula (index) {
        return $scope.instrutores.some (instrutor => instrutor.aula.includes($scope.aulas[index].id));
        }

    function filtrarPorNome() {
         var arrayCom1objeto = $scope.aulas.filter(function(aula){ return aula.nome===$scope.list})
         return arrayCom1objeto;
    }
    function filtrarPorID(id) {
         var arrayCom1objeto = $scope.aulas.filter(function(aula){ return aula.id===id})
         return arrayCom1objeto;
    }


    $scope.remover= function (id){
      var  array = filtrarPorID(id);
      var itemIndex = $scope.aulas.indexOf(array[0]);
      if (procurarAula(itemIndex)){
            return alert("Não é possível excluir esta aula. Está sendo utilizada.");
       }
       else {
        $scope.aulas.splice(itemIndex, 1);
         alert("Remoção executada com sucesso.")
        }
    }
  });
  modulo.controller("InstrutoresController", function ($scope){
    $scope.controller = "aaaaaaaaaaaaaaaaaaaoi"


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


   $scope.incluirInstrutor = function (){
     if (typeof $scope.nomeInstrutor==="undefined"){
      return alert ("É necessário preencher o nome para incluir instrutor.")
     }
     if (typeof $scope.sobrenomeInstrutor==="undefined"){
       return alert ("É necessário preencher o sobrenome para incluir instrutor.")
     }
     if (typeof $scope.idadeInstrutor==="undefined"){
       return alert ("É necessário preencher a idade para incluir instrutor.")
     }
     if (typeof $scope.emailInstrutor==="undefined"){
       return alert ("É necessário preencher o email para incluir instrutor.")
     }
     var b
       if (procurarPorInstrutor()){
          return alert("Instrutor  já cadastrado.");}
       if (procurarPorEmail()){
         return alert("Email já está sendo utilizado.")
       }
       if (typeof $scope.imgInstrutor==="undefined"){
         $scope.imgInstrutor = "img/Default.png";
       }

       if (typeof $scope.aulaInstrutor==="undefined"){
       $scope.aulaInstrutor =null;
      }
      else {
     $scope.aulaInstrutor = $scope.aulaInstrutor.map(Number)
      }
       if  ($scope.myForm2.$valid){
          $scope.novoInstrutor = {id:$scope.instrutores.length, nome: $scope.nomeInstrutor, sobrenome: $scope.sobrenomeInstrutor,
          idade: $scope.idadeInstrutor, email:$scope.emailInstrutor, dandoAula: $scope.dandoAula, aula:  $scope.aulaInstrutor, urlFoto: $scope.imgInstrutor}
          $scope.instrutores.push(angular.copy($scope.novoInstrutor));
          $scope.novoInstrutor = {};
          alert("Inclusão realizada.");

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
        if (typeof $scope.nomeInstrutor==="undefined"){
          objeto.nome =objeto.nome;
        }
        else {
          objeto.nome = $scope.nomeInstrutor
        }
        if (typeof $scope.sobrenomeInstrutor==="undefined"){
          objeto.sobrenome =objeto.sobrenome;
        }
        else {
          objeto.sobrenome = $scope.sobrenomeInstrutor
        }
        if (typeof $scope.idadeInstrutor==="undefined"){
          objeto.idade =objeto.idade;
        }
        else {
          objeto.idade = $scope.idadeInstrutor
        }
        if (typeof $scope.emailInstrutor==="undefined"){
          objeto.email =objeto.email;
        }
        else {
          objeto.email= $scope.emailInstrutor
        }
        if (typeof $scope.dandoAula==="undefined"){
          objeto.dandoAula =objeto.dandoAula;
        }
        else {
          objeto.dandoAula = $scope.dandoAula
        }
        if (typeof $scope.aulaInstrutor==="undefined"){
          objeto.aula =objeto.aula;
        }
        else {
          objeto.aula = $scope.aulaInstrutor
        }
        if (typeof $scope.imgInstrutor==="undefined"){
          objeto.urlFoto =objeto.urlFoto;
        }
        else {
          objeto.urlFoto = $scope.imgInstrutor
        }
         alert("Alteração realizada.")

        }

      function filtrarPorNomeInstrutor() {
           var arrayCom1objeto = $scope.instrutores.filter(function (instrutor) {return instrutor.nome===$scope.listInstrutores})
           return arrayCom1objeto;
      }

      $scope.listInstrutores;

  $scope.removerInstrutor= function ( id){
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

});
*/
