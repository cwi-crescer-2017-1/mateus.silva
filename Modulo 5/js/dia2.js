
var modulo = angular.module('data', []);
modulo.filter('mascada', function () {
  return function (nome) {
    return nome.replace(/(nunes)/i, "$ $1 $");
  };
});
modulo.controller('controller1', function($scope, $filter) {
$scope.imprime = function () {
  $scope.data = new Date ($scope.date);
}

  let instrutores = [{
    nome: 'Bernardo',
    aula: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  },
  {
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  }
];
$scope.instrutores = instrutores;
console.log($filter('mascada')('teste nunes teste'));
})
