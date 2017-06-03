modulo.factory("registrarService", function ($http){

var url ="http://localhost:52372/api/acessos/registrar"

function post (novoUsuario){
  console.log(novoUsuario);
  return $http.post (url, novoUsuario)
}

return{
  registrar:post
}


});
