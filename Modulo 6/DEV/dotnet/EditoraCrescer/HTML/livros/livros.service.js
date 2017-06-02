modulo.factory("livrosService", function ($http){

var url = "http://localhost:52372/api/livros"

function get (){
   return $http.get (`${url}/lancamentos`);
};

function getAll(){
 return $http.get (url);
};

function paginacao(parametros) {
      return $http.get(`${url}/${parametros.quantidadePular}/${parametros.quantidadeTrazer}`)
};

return{
  buscar :paginacao,
  buscarLancamentos: get,
  buscarTodosOsLivros: getAll
}
});
