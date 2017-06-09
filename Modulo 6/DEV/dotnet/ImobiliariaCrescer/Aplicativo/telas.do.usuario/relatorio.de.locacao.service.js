modulo.factory("relatorioDeLocacaoService", function ($http){

var url = "http://localhost:63184/api/pedidos/relatoriodelocacaomensal";

function get(){
  return $http.get(url);
};

function soma(){
  return $http.get(url+"valor");
  };
  
return{
  buscarRelatorio:get,
  buscarSoma: soma
}
});
