var app = angular.module('poke', []);
app.controller('controller1', function($scope) {
     var pokemons = [{nome: 'Pokémon 1', tipo:'fogo' }, {nome: 'Pokémon 2', tipo:'água' },
     {nome: 'Pokémon 3', tipo:'elétrico' }];
   $scope.pokemons= pokemons;
  })

//  Ex. anterior
//   var app = angular.module('poke', []);
//    app.controller('controller1', function($scope) {
//       var pokemon = {nome: '', tipo:'' };
//     $scope.pokemon= pokemon;
//    })
