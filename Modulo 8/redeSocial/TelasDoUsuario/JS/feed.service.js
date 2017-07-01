modulo.factory("feedService", function ($http){


var url ="http://localhost:9090/api/usuario/username/"
var urlPost  ="http://localhost:9090/api/post"

function get(usuario){
    return $http.get (url + usuario+"/")
}

function post (post){
    return $http.post(urlPost, post)
}
function getPosts (){
    return $http.get(urlPost)
}

    return{
      userGet:get,
      postar : post,
      getPosts:getPosts
  }


});
