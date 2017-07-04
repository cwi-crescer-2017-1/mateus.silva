modulo.factory("amigosService", function ($http){


var url ="http://localhost:9090/api/usuario/"
var posts="http://localhost:9090/api/post/"
var urlRelationship= "http://localhost:9090/api/relationship/"

function getAmigos(){
    return $http.get (url + "amigos")
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

function situacao (idAmigo){
    return $http.get(urlRelationship +"situacao/"+idAmigo)
}

function add (r){
    return $http.post( urlRelationship +"add/"+r)
}



return {
  loadAmigos:getAmigos,
  getUsuarios: getUsuarios,
  loadAmigoPerfil:getPerfil,
  loadAmigoPosts:loadPostByIdUser,
  add:add,
  situacao: situacao,

}


});
