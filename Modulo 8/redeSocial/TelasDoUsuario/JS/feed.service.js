modulo.factory("feedService", function ($http){


var url ="http://localhost:9090/api/usuario/username/"
var urlPost  ="http://localhost:9090/api/post"
var urlUsuarios ="http://localhost:9090/api/usuario/lista"
var urlSolicitacoes = "http://localhost:9090/api/usuario/solicitacoes/"
function get(usuario){
    return $http.get (url + usuario+"/")
}

function post (post){
    return $http.post(urlPost, post)
}
function getPosts (){
    return $http.get(urlPost)
}

function getUsuarios (){
    return $http.get(urlUsuarios)
}

function getSolicitacoes (){
    return $http.get(urlSolicitacoes+ 50 )
}

    return{
      userGet:get,
      postar : post,
      getPosts:getPosts,
      getUsuarios: getUsuarios,
      solicitacoes : getSolicitacoes
  }


});
