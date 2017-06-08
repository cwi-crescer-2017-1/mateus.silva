modulo.factory("relatorioDeLocacaoService", function ($http){

var url = "http://localhost:63184/api/pedidos/relatoriodelocacaomensal";



  function get(){
   return $http.get(url);
  };

return{
  buscarRelatorio:get
}
});
