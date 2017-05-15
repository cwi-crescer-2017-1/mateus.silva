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
		          invalidas+=  series[i].titulo +" - ";
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
function procurarPorNome (series, nome) {
var serieAtual;
var existeNome = false;
for (var i=0 in series){
	serieAtual = series[i];
	for (var a=0 in serieAtual.elenco){
		  if (series[i].elenco[a].includes(nome)){
     			existeNome =true;
     			break;
}}}
 return existeNome;
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
var arrayQueroGenero = [];
var serieAtual;
for (var i=0 in series){
	serieAtual = series[i];
	for (var a=0 in serieAtual.genero){
		  if (genero===series[i].genero[a]){
     			 arrayQueroGenero.push(series[i].titulo)
}}}
 return arrayQueroGenero;
}
console.log(queroGenero("Suspense"));
console.log(queroGenero("Crime"));

//------------------------------------------------------------------------
//Exercício 6-B

function queroTitulo (titulo) {
 var arrayQueroTitulo = [];
 var serieAtual;
 var tituloSplit = titulo.split(" ");
 for (var i=0 in series){
	  serieAtual = series[i];
    var temSemelhante = false;
   for (var a=0 in tituloSplit){
		   palavraAtual = tituloSplit[a];
       var arrayTitulo = (series[i].titulo).split(" ");
       for (var b=0 in arrayTitulo){
			     var temSemelhante = palavraAtual.search(arrayTitulo[b])>=0;
           if (temSemelhante){
   		         arrayQueroTitulo.push(series[i].titulo);
       }
}}}
 return arrayQueroTitulo;
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
  for (var i=0 in diretorSort){
    var imprime = diretorSort[i]
    console.log(imprime);}

    var elencoNomes = serie.elenco;
    var elencoSort = elencoNomes.sort(compare);
    console.log("------Elenco--------");
    for (var i=0 in elencoSort){
	     var imprime = elencoSort[i]
       console.log(imprime);}
       console.log("")
}
creditosIlluminatis(series[1])
creditosIlluminatis(series[2])
//----------------------------------------------------------------------------------------
//Exercício 8
function temAbreviacao (series) {
    var ComAbreviacao;
    var contador = 0;
    var nome;
    for (var a= 0 in  series){
	     var serie = series[a];
    for (var i = 0 in  serie.elenco){
       nome = serie.elenco[i];
       var ponto = /\./g;
       var resultado = nome.match(ponto);
       if (resultado!== "undefined" && resultado!==null){
          contador ++;
     }
       if (contador ===serie.elenco.length) {
         ComAbreviacao =serie;
 }
}
}return ComAbreviacao;
}

function hashtag (serie) {
  var  hashtag = "#";
  for (var i = 0 in serie.elenco){
       var arraySplit = serie.elenco[i].split(" ");
       for (var a = 0 in arraySplit){
	     var nome = arraySplit[a];
	     var encontraPalavra = /\./g;
	     var palavra = nome.match(encontraPalavra);
	     if (palavra=="." && nome!=="Jr."){
	         hashtag += nome.substring(nome.length-1, 0)
              }
  }    }
return hashtag;
}

console.log(hashtag(temAbreviacao(series)))
