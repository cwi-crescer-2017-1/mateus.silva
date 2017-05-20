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
$scope.incluir = function () {
   if ($scope.myform.$valid) {
     $scope.instrutores.push(angular.copy($scope.novoInstrutor));
     $scope.novoInstrutor = {};
     console.log($scope.novoInstrutor)
   }
 };
$scope.aulas =  [
  'OO',
  'HTML e CSS',
  'Javascript',
  'AngularJS',
  'Banco de Dados I'
];
});
