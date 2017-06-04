modulo.factory("livrosService", function ($http){

var url = "http://localhost:52372/api/livros"

function get (){
   return $http.get (`${url}/lancamentos`);
};



function getNaoPuclicados(){
 return $http.get(`${url}/naopublicados`);
};

function paginacao(page) {
      return $http.get(`${url}/${page}/${10}`)
};

return{
  buscar :paginacao,
  buscarLancamentos: get,
  naopublicados : getNaoPuclicados
}
});
