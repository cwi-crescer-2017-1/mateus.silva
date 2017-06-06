modulo.factory("informaOUsuarioService", function ($http){

var url = "http://localhost:63184/api/clientes"


function get(){
 return $http.get(`${url}`);
};

return{
  listarClientes : get 
}

});
