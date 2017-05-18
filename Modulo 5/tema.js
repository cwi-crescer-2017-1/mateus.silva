var modulo = angular.module('poke', []);
modulo.controller('controller1', function($scope) {
     var pokemons =
     [{nome: 'BULBASAUR', tipo:'Grama'},
      {nome: 'IVYSAUR', tipo:'Grama'},
      {nome: 'VENUSAUR', tipo:'Grama'},
      {nome: 'CHARMANDER', tipo:'Fogo'},
      {nome: 'CHARMELEON', tipo:'Fogo'},
      {nome: 'CHARIZARD', tipo:'Fogo'},
      {nome: 'SQUIRTLE', tipo:'Água'},
      {nome: 'WARTORTLE', tipo:'Água'},
      {nome: 'BLASTOISE', tipo:'Água'},
      {nome: 'CATERPIE', tipo:'Verme'}];
   $scope.pokemons= pokemons;
  })
