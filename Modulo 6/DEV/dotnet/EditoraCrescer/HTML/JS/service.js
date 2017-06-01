modulo.factory("service", function ($http){

var url = "http://localhost:52372/api/livros"

function get (){
   return $http.get (`${url}/lancamentos`);
};






return{

  buscarLancamentos: get
}



});
