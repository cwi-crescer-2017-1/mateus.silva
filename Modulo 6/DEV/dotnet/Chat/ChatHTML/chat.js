modulo.filter("mascada", function (){
  return function (mascada){
    if (mascada.includes("nunes")){
      return "$$$$$$$";
    }
  }
})

modulo.controller("mainController", function ($scope, $filter, chatService){

prompt ("Digite seu nome");
prompt("Insira uma foto");
  $scope.enviarMensagem = function (input){
  chatService.enviarMensagem(input).then(function (response){
    buscarMensagens();
    })};

    function buscarMensagens (){
  chatService.buscarMensagens().then(function(response){
      $scope.frases = response.data;
  })};
});
