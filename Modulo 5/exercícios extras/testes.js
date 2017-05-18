var modulo = angular.module('poke', []);
modulo.controller('controller1',['$scope', function($scope) {
  $scope.removePokemon = function (pokemon){
    var remove = $scope.pokemons.indexof(pokemon)
      $scope.pokemons.splice(remove, 1)}

   $scope.pokemons=   [{nome: 'BULBASAUR', tipo:'Grama', disponivel: true},
       {nome: 'IVYSAUR', tipo:'Grama', disponivel: true},
       {nome: 'VENUSAUR', tipo:'Grama', disponivel: true},
       {nome: 'CHARMANDER', tipo:'Fogo', disponivel: true},
       {nome: 'CHARMELEON', tipo:'Fogo', disponivel: true},
       {nome: 'CHARIZARD', tipo:'Fogo', disponivel: true},
       {nome: 'SQUIRTLE', tipo:'Água', disponivel: true},
       {nome: 'WARTORTLE', tipo:'Água', disponivel: true},
       {nome: 'BLASTOISE', tipo:'Água', disponivel: true},
       {nome: 'CATERPIE', tipo:'Verme', disponivel: true}];

 }])
