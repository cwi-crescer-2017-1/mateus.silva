modulo.factory("relatorioDeAtrasoService", function ($http){

var url = "http://localhost:63184/api/pedidos/relatoriodeatrasos";



  function get(){
   return $http.get(url);
  };

return{
  buscarRelatorio:get
}
});
