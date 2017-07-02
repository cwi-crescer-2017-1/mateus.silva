modulo.factory("feedService", function ($http){


var url ="http://localhost:9090/api/usuario/username/"
var urlPost  ="http://localhost:9090/api/post"
var urlUsuarios ="http://localhost:9090/api/usuario/lista"
var urlSolicitacoes = "http://localhost:9090/api/usuario/solicitacoes/"
var urlAceitar= "http://localhost:9090/api/relationship/"

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

function getSolicitacoes (idUsuarioLogado){
    return $http.get(urlSolicitacoes+ idUsuarioLogado)
}

function aceitarAmizade (r, e){
    return $http.post(urlAceitar +"aceitar/"+r+"/"+e)
}

function rejeitarAmizade (r, e){
    return $http.post(urlAceitar +"recusar/"+r+"/"+e)
}

function atualizar (usuario){
    return $http.post("http://localhost:9090/api/usuario/editar/", usuario)
}

    return{
      userGet:get,
      postar : post,
      getPosts:getPosts,
      getUsuarios: getUsuarios,
      solicitacoes : getSolicitacoes,
      aceitar : aceitarAmizade,
      recusar: rejeitarAmizade,
      editar: atualizar
  }


});
