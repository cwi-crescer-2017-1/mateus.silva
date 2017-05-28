modulo.factory("chatService", function ($http){

let url = "http://localhost:61611/api/chat";


function get (){
   return $http.get (url);

};

function post (input, usuario, img){
   var json = {Usuario: usuario, Img: img, Frase : input}
   return $http.post(url, json)
}


return{
  enviarMensagem: post,
  buscarMensagens: get
}
})
