var modulo = angular.module("myApp", []);
modulo.controller("mainController", function ($scope) {

$scope.instrutores =  [
  {
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: 'OO'
  }
];

$scope.incluir = function (){
    $scope.instrutores.push($scope.novoInstrutor)
 console.log($scope.instrutores)
};

$scope.copy  = $scope.instrutores;

$scope.aulas =  [
  'OO',
  'HTML e CSS',
  'Javascript',
  'AngularJS',
  'Banco de Dados I'
];
});
