modulo.factory("amigosService", function ($http){


var url ="http://localhost:9090/api/usuario/"
var posts="http://localhost:9090/api/post/"
var urlRelationship= "http://localhost:9090/api/relationship/"

function get(id){
    return $http.get (url + "amigos/"+50 )
}

function getPerfil(id){
    return $http.get (url + id )
}

function loadPostByIdUser(id){
    return $http.get (posts + id )
}
function getUsuarios (){
    return $http.get(url+"lista")
}

function situacao (r, e){
    return $http.get(urlRelationship +"situacao/"+r+"/"+e)
}

function add (r, e){
    return $http.post( urlRelationship +"add/"+r+"/"+e)
}

return {
  loadAmigos:get,
  getUsuarios: getUsuarios,
  loadAmigoPerfil:getPerfil,
  loadAmigoPosts:loadPostByIdUser,
  add:add,
  situacao: situacao
}


});
