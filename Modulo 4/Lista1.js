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
for (var i = 0; i<array.length; i++)
     var string =  array[i];
     var maiorString = 0;
     if (string.length> maiorString){
       maiorString = string;
     }

   return maiorString;
 }
 console.log(maiorTexto(array = ["lala", "lalala", "lalalala"]));
 console.log(maiorTexto(array = ["lala", "lalala"]));

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
      return function (b){
        return a + b;
      }
    }
     return a + b;
   }
   console.log(adicionar(3)(4));
   console.log(adicionar(5642)(8749));

   //------------------------------------------------------------
   //Exercício 5

 function fiboSum (numerosDaSequencia) {
   var soma = 0;
   for (var  i = 0; i<numerosDaSequencia; i++){
      if (i===0) {
         fiboSum[i] =1;
         soma+= fiboSum[i]}
      else if (i===1) {
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
