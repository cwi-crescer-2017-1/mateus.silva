modulo.factory("cadastroService", function ($http){

  var url = "http://localhost:63184/api/clientes"


  function post(cliente){
   return $http.post(`${url}`, cliente);
  };

return{
  cadastrar:post
}
});
