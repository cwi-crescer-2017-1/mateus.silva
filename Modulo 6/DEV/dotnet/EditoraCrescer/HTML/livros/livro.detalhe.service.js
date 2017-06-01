modulo.factory("livroDetalheService", function ($http) {

var url = "http://localhost:52372/api/livros/";


function get(isbn){
  return $http.get(url + isbn);
}

return {
   buscarPorId :get
}
});
