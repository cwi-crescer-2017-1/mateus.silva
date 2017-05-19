var modulo = angular.module("myApp", []);
modulo.filter('mascada', function () {
  return function (nome) {
    return nome.replace(/(nunes)/i, "$ $1 $");
  };
});
modulo.filter('ipad', function () {
        return function (variavel, tamanho) {
          if (typeof variavel ==="number"){
                  var numero = variavel.toString();
                   var num = "0"+numero;
                   var numeroTamanho = num;
             while(numeroTamanho.length<tamanho){
                      num ='0'+num;
                      numeroTamanho++;}    
            return num;}
            else {return variavel.toUpperCase();
            }
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
instrutores.forEach ((instrutor) =>{instrutor.aula.forEach(aula =>
  {array.push({ 'instrutor': instrutor.nome, 'aula': aula.nome, 'numero': aula.numero })})})
$scope.instrutores = array;

console.log(array);
});
