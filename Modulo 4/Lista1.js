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
