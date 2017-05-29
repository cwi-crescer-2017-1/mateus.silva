modulo.controller("mainController", function ($scope, chatService){

setInterval(function (){
    var scroll= document.getElementById("main");
      scroll.scrollTop = scroll.scrollHeight;
      buscarMensagens()}, 1000);


  $scope.enviarMensagem = function (input){
    if (input=== undefined){
      input = "";
    }
    var usuario = window.localStorage.getItem("nome")
    var  img = window.localStorage.getItem("img")
      chatService.enviarMensagem(input, usuario, img).then(function (response){
      buscarMensagens();
            $scope.input = {};
    })};


  function buscarMensagens (){
      chatService.buscarMensagens().then(function(response){
      $scope.frases = response.data;

  })};

  //window.localStorage.clear();
  $scope.url = window.localStorage.getItem("img")

  if (window.localStorage.getItem("nome")=== null){
      var usuario = prompt ("Digite seu nome.");
     var img= prompt("Insira uma foto.");
      window.localStorage.setItem("nome", usuario)
      window.localStorage.setItem("img", img)
    }
});
