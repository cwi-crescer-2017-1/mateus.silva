modulo.factory("devolucaoService", function ($http){

var url = "http://localhost:63184/api/";

function get(){
 return $http.get(url+"/pedidos");
};

function put(pedido){
 return $http.put(url+"produtos/", pedido);
};

function DataDeEntrega(pedido){
 return $http.put(url+"pedidos/"+ pedido.Id, pedido);
};
return{
  buscarPedidos : get,
  devolver:put,
  colocarDataDeEntrega: DataDeEntrega
}

});
