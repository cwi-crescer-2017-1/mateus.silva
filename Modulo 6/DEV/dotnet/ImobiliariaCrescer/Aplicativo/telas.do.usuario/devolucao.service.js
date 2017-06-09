modulo.factory("devolucaoService", function ($http){

var url = "http://localhost:63184/api/";

function get(){
 return $http.get(url+"/pedidos");
};

function DataDeEntrega(pedido){
 return $http.put(url+"pedidos/"+ pedido.Id, pedido);
};

return{
  buscarPedidos : get,
  colocarDataDeEntrega: DataDeEntrega
}

});
