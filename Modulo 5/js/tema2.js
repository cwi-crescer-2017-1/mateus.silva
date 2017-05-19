var modulo = angular.module("myApp", []);
modulo.filter('mascada', function () {
  return function (nome) {
    return nome.replace(/(nunes)/i, "$ $1 $");
  };
});
modulo.filter('numberFixedLen', function () {
        return function (numero, tamanho) {
            var num = parseInt(numero, 10);
             len = parseInt(tamanho, 10);
             var num = ''+numero;
            while ((num.length+1) < tamanho) {
                num = '0'+num;
            }
            return num;
        };
    });
  modulo.filter('upper', function () {
      return function (nome) {
        return nome.toUpperCase();
      };
    });
modulo.controller("mainController", function ($scope) {
  let instrutores = [{
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
    },
    {
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
    }
  ];

var array = []
instrutores.forEach ((instrutor) =>{if (instrutor.aula.length>1){instrutor.aula.forEach(aula =>
     {array.push({ 'instrutor': instrutor.nome, 'aula': aula.nome, 'numero': aula.numero })})}
       else {instrutor.aula.forEach(aula =>
        {array.push({'instrutor': instrutor.nome, 'aula': aula.nome, 'numero': aula.numero })})}})
$scope.instrutores = array;

console.log(array);
});
