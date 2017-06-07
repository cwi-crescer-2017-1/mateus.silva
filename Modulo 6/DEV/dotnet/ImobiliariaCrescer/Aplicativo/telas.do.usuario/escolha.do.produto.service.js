modulo.factory("escolhaDoProdutoService", function ($http){

var url = "http://localhost:63184/api/clientes"

function getPorId(id){
 return $http.get(url+ "/"+ id);
};


return{
  buscarClientePorId:getPorId
}

})
;
