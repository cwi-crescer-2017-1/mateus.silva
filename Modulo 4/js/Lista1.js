//Exercício 1

function daisyGame(a) {
  if (a%2 ===1) {
    return "Love me";
  }else {
    return "Love me not";}
  }
console.log(daisyGame(1))
console.log(daisyGame(2))
console.log(daisyGame(3))
console.log(daisyGame(4))

//------------------------------------------------------------
//Exercício 2

function maiorTexto(array) {
  var maiorString = array [0];
for (var i = 0; i<array.length; i++){
     var string =  array[i];
     if (string.length> maiorString.length){
       maiorString = string;
     }
}
   return maiorString;
 }
 console.log(maiorTexto(["lala", "lalala", "lalalala"]));
 console.log(maiorTexto(["lala", "lalala"]));

//------------------------------------------------------------
//Exercício 3


function saudacao(instrutor)  {
 console.log('olá querido instrutor: ', instrutor)
}
function imprime (arrayDeStrings, funcao) {
  if (typeof funcao === 'function'){
    for (var i = 0; i < arrayDeStrings.length; i++){
         funcao(arrayDeStrings[i]);
       }
    }
    else {
      console.log('TypeError: number is not a function');
    }
  }

 console.log(imprime(["Bernardo", "Nunes", "Fabrício", "Ben-hur", "Carlos"],
 saudacao))
 console.log(imprime(["Bernardo", "Nunes", "Fabrício", "Ben-hur", "Carlos"],
 1233))

 //------------------------------------------------------------
 //Exercício 4

 function adicionar(a,b) {
   if (arguments.length ===1){
      return function adicionar (b){ // retorna a função adicionar se tiver um argumento,
        return a + b;                //ou seja, quando houver (a)(b) a função adicionar retorna ela mesma e depois executa a soma.
      }                              //Desta forma, na primeira chamada usa o argumento "a" e na segunda usa o "b".
    }
   return a + b; // se tiver dois argumentos, executa a soma diretamente.
   }
   console.log(adicionar(3)(4));
   console.log(adicionar(5642)(8749));

   //------------------------------------------------------------
   //Exercício 5

 function fiboSum (numerosDaSequencia) {
   var soma = 0;
   for (var  i = 0; i<numerosDaSequencia; i++){
      if (i===0||i===1) {
         fiboSum[i] =1;
         soma+= fiboSum[i]}
      else {
         fiboSum[i] = fiboSum[i-1] + fiboSum[i-2];
         soma+= fiboSum[i]}
  }
  return soma;
}
console.log(fiboSum(7));
console.log(fiboSum(3));

//------------------------------------------------------------
//Exercício 6

function queroCafe (a,b) {
  var numeros = "";
 do{
     posicoesSendoTrocadas = false;
      for (var i = 0; i<b.length; i++){
          var precoPosicaoAtual =  b[i];
          var precoPosicaoProxima = b[i+1];
          if(precoPosicaoAtual>precoPosicaoProxima){
              var guardaPreco = b[i];
              b[i] = b[i+1];
              b[i+1] = guardaPreco;
             posicoesSendoTrocadas = true;
          }
       }
    } while (posicoesSendoTrocadas);

    for (var i = 0; i< b.length; i++){
  	   if (b[i]<=a) {
         numeros+= b[i]+",";
        }
      }
  return numeros.substring(numeros.length-1, 0);
}

console.log(queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]));
