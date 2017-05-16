console.log(series);
//------------------------------------------------------------------------
//Exercício 1
function seriesInvalidas(series){
    ano = new Date().getFullYear();
    var invalidas = "";
    series.forEach(serie =>  {
         let algumCampoInvalido = Object.values(serie).some(valor => {
         let valorInvalido = (typeof  valor  ==="undefined" ||  valor=== null);
         let anoInvalido = serie.anoEstreia>ano;
         return valorInvalido || anoInvalido;});
         if(algumCampoInvalido){
         invalidas+= serie.titulo + " - ";}
    })
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
function procurarPorNome (series, nome) {
  return series.some (serie => serie.elenco.some(elenco => elenco.includes(nome)));
}

 console.log(procurarPorNome(series, "Mateus"))
 console.log(procurarPorNome(series, "lalaa"))
 console.log(procurarPorNome(series, "Winona Ryder"))
 console.log(procurarPorNome(series, "Noah Schnapp"))
 //------------------------------------------------------------------------
 //Exercício 5
 function mascadaEmSerie(serie) {
   var mascadaElenco = 0;
   var mascadaDiretores = 0;
   var mascada = 0;
	 mascadaElenco= serie.elenco.length*40000;
	 mascadaDiretores+= serie.diretor.length*100000;
 return mascada = mascadaElenco + mascadaDiretores;
}
console.log(mascadaEmSerie(series[0]));
console.log(mascadaEmSerie(series[1]));
console.log(mascadaEmSerie(series[2]));

//------------------------------------------------------------------------
//Exercício 6-A
function queroGenero (genero) {
    return series.filter (serie => serie.genero.includes(genero));
}
console.log(queroGenero("Suspense"));
console.log(queroGenero("Crime"));

//------------------------------------------------------------------------
//Exercício 6-B
function queroTitulo (titulo) {
  return series.filter( serie => serie.titulo.includes(titulo)).map(serie => serie.titulo);
}
console.log(queroTitulo("Narcos"));
console.log(queroTitulo("The"));
console.log(queroTitulo("of"));

//Exercício 7
function creditosIlluminatis (serie) {
  function compare(a, b) {
      aSemEspaco = a.trim();
      bSemEspaco= b.trim();
      var splitA = aSemEspaco.split(" ");
      var splitB = bSemEspaco.split(" ");
      var ultimoA = splitA[splitA.length - 1];
      var ultimoB = splitB[splitB.length - 1];

      if (ultimoA < ultimoB) return -1;
      if (ultimoA > ultimoB) return 1;

  }
    console.log(serie.titulo);
   var diretorNomes= serie.diretor;
   var diretorSort = diretorNomes.sort(compare);
   console.log("------Diretores--------");
   diretorSort.forEach(diretor => console.log(diretor));
   var elencoNomes = serie.elenco;
   var elencoSort = elencoNomes.sort(compare);
   console.log("------Elenco--------");
   elencoSort.forEach (ator => console.log(ator));
}
creditosIlluminatis(series[1])
creditosIlluminatis(series[2])
//----------------------------------------------------------------------------------------
//Exercício 8
function temAbreviacao (series) {
    return series.find(serie => serie.elenco.every (nome =>nome.match(/\./g)));
}

function hashtag (serie) {
  var  hashtag = "#";  
  for (var i = 0 in serie.elenco){
       var arraySplit = serie.elenco[i].split(" ");
       for (var a = 0 in arraySplit){
	     var nome = arraySplit[a];
	     var encontraPalavra = /\./g;
	     var palavra = nome.match(encontraPalavra);
	     if (palavra=="." && nome===nome.toUpperCase()){
	         hashtag += nome.substring(nome.length-1, 0)
              }
  }    }
return hashtag;
}

console.log(hashtag(temAbreviacao(series)))
