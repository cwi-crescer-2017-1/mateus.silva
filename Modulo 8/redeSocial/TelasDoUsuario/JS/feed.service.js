modulo.factory("feedService", function ($http){


  var url ="http://localhost:9090/api/usuario/username/"

function get(usuario){
console.log(usuario);
    return $http.get (url + usuario+"/")
}



    return{
      userGet:get
  }


});
