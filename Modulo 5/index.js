var app = angular.module('poke', []);
app.controller('controller1', function($scope) {
     var pokemon = {nome: 'pikachu'};
   $scope.pokemon= pokemon;
  })
