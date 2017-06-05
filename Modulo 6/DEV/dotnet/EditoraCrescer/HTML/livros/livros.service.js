modulo.factory("livrosService", function ($http){

var url = "http://localhost:52372/api/livros"

function get (){
   return $http.get (`${url}/lancamentos`);
};

function getExcetoLancamentos(){
 return $http.get(`${url}/excetolancamentos`);
};

function paginacao(page) {
      return $http.get(`${url}/${page}/${10}`)
};

return{
  buscar :paginacao,
  buscarLancamentos: get,
  excetoLancamentos : getExcetoLancamentos
}
});
