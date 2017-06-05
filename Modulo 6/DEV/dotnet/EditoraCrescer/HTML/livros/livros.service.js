modulo.factory("livrosService", function ($http){

var url = "http://localhost:52372/api/livros"

function getExcetoLancamentos(){
 return $http.get(`${url}/excetolancamentos`);
};

function paginacao(page) {
      return $http.get(`${url}/${page}/${10}`)
};

function getSohLancamentos(){
 return $http.get(`${url}/sohLancamentos`);
};

function paginacaoLancamentos(page) {
      return $http.get(`${url}/sohLancamentos/${page}/${1}`)
};

return{
  buscar :paginacao,
  excetoLancamentos : getExcetoLancamentos,
  sohLancamentos: getSohLancamentos,
  buscarLancamentos: paginacaoLancamentos
}
});
