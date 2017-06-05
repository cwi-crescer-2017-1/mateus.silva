modulo.factory('crudService', function ($http) {

var url = "http://localhost:52372/api/livros"


function getAll(){
   return $http.get(`${url}/naopublicados`);
  };

function post(livro){
   return $http.post (url, livro);
  };

function put (livro){
   return $http.put(url+ "/" +livro.Isbn, livro);
}

function deletar (livro){
  return $http.delete(url+"/"+ livro.Isbn)
}

return {
     listar: getAll,
     criar: post,
     update: put,
     deletar: deletar
  };
});
