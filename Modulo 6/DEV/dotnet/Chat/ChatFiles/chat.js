modulo.filter("mascada", function (){
    return function (texto){
    if (texto ==="undefined"){
        return;
    }
    if (texto.includes("nunes")){
        return texto.replace(/(nunes)/i, "$$$$$$$$$ $$$$$$$$$")
    }
    else {
        return texto;
    }
  }
});
modulo.controller("mainController", function ($scope, $filter, chatService){


setInterval(function (){
      var scroll= document.getElementById("main");
      scroll.scrollTop = scroll.scrollHeight;
      buscarMensagens()}, 2000);


  $scope.enviarMensagem = function (input){
    let usuario = window.localStorage.getItem("nome")
    let img = window.localStorage.getItem("img")
      chatService.enviarMensagem(input, usuario, img).then(function (response){
      buscarMensagens();
    })};



  function buscarMensagens (){
      chatService.buscarMensagens().then(function(response){
      $scope.frases = response.data;
      console.log(window.localStorage.getItem("img"));
      console.log(typeof $scope.url);
  })};



  //window.localStorage.clear();
  $scope.url = window.localStorage.getItem("img")

  if (window.localStorage.getItem("nome")=== null){
      let usuario = prompt ("Digite seu nome.");
      let foto = prompt("Insira uma foto.");
      window.localStorage.setItem("nome", usuario)
      window.localStorage.setItem("img", foto)
    }
});
