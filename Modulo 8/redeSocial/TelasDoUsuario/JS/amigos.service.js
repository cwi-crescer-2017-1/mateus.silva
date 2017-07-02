modulo.factory("amigosService", function ($http){


var url ="http://localhost:9090/api/usuario/"
function get(id){
    return $http.get (url + "amigos/"+50 )
}

function getPerfil(id){
    return $http.get (url + id )
}


return {
  loadAmigos:get,
  loadAmigoPerfil:getPerfil
}


});
