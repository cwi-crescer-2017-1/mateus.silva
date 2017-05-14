console.log(series);
//------------------------------------------------------------------------
//Exercício 1
function seriesInvalidas(series){
 data  = new Date();
 ano = data.getFullYear();
 var invalidas = " ";
 for (var i = 0; i <series.length; i++){
   var arrayAtributos = [series[i].diretor, series[i].distribuidora, series[i].elenco, series[i].genero, series[i].temporadas,
    series[i].titulo,  series[i].numeroEpisodios];
   for (var a = 0; a <arrayAtributos.length; a++){
     if (series[i].anoEstreia>ano ||
        typeof arrayAtributos[a] ==="undefined" ||  arrayAtributos[a]  === null){
		          invalidas+=  "Série "+ i +" - ";
             break;}
       }
 }
return "Séries inválidas : " + invalidas.substring(invalidas.length-2, 0);
}
console.log(seriesInvalidas(series));

//------------------------------------------------------------------------
//Exercício 2

function filtrarSeriesPorAno(series, ano) {
       var novoArray = series.filter(function(series){ return series.anoEstreia>=ano })
       return novoArray;
}
console.log(filtrarSeriesPorAno(series, 2017))
console.log(filtrarSeriesPorAno(series, 2010))

//------------------------------------------------------------------------
//Exercício 3
function mediaDeEpisodios (series) {
soma = 0;
contador = 0;
series.forEach(function (series) {contador++; return soma+=series.numeroEpisodios;} )
return soma/contador;
}
console.log(mediaDeEpisodios (series))

//------------------------------------------------------------------------
//Exercício 4
