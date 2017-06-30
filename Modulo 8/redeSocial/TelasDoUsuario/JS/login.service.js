modulo.factory("loginService", function ($http){

var url ="http://localhost:9090/api/usuario"

function post (usuario){
    return $http.post (url, usuario)
  }
  // 
  // function get (usuario){
  //     return $http.get (url, usuario)
  //   }

  return{
    cadastrar:post
    // logar:get
  }



})
