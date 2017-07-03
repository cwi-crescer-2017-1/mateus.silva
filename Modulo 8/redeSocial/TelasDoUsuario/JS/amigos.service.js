modulo.factory("amigosService", function ($http){


var url ="http://localhost:9090/api/usuario/"
var posts="http://localhost:9090/api/post/"
function get(id){
    return $http.get (url + "amigos/"+50 )
}

function getPerfil(id){
    return $http.get (url + id )
}

function loadPostByIdUser(id){
    return $http.get (posts + id )
}


return {
  loadAmigos:get,
  loadAmigoPerfil:getPerfil,
  loadAmigoPosts:loadPostByIdUser
}


});
