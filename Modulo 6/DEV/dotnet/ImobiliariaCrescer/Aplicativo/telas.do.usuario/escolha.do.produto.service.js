modulo.factory("escolhaDoProdutoService", function ($http){

var url = "http://localhost:63184/api/"

function getPorId(id){
 return $http.get(url+ "clientes"+ "/"+ id);
};

function getPacotes(){
 return $http.get(url+ "produtos/pacotes");
};


function getOpcionais(){
 return $http.get(url+ "produtos/opcionais");
};


return{
  buscarClientePorId:getPorId,
  buscarPacotes: getPacotes,
  buscarOpcionais: getOpcionais
}

})
;
