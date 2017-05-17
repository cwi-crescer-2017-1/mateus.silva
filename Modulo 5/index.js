var app = angular.module('poke', []);
app.controller('controller1', function($scope) {
     var pokemon = {nome: 'pikachu', tipo:'elétrico' };
   $scope.pokemon= pokemon;
  })
