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
