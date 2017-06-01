modulo.factory("livrosService", function ($http){

var url = "http://localhost:52372/api/livros"

function get (){
   return $http.get (`${url}/lancamentos`);
};


function getAll(){
   return $http.get (url);
};



return{

  buscarLancamentos: get,
  buscarTodosOsLivros: getAll
}



});
