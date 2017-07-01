modulo.factory("loginService", function ($http){

var url ="http://localhost:9090/api/acessos"

function post (usuario){
  console.log(usuario);
    return $http.post (url, usuario)
  }



  return{
    cadastrar:post
}})
