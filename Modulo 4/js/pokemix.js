
document.addEventListener('DOMContentLoaded', function() {
  let btnPesquisar = document.getElementById('btnPesquisar');
  btnPesquisar.onclick = function() {
    var cor = document.getElementById("corEscolhida").value;
     document.body.style.backgroundColor = cor;

let urls =  [ "http://pokeapi.co/api/v2/pokemon/"+parseInt((Math.random()*720).toFixed(0))+"/",
"http://pokeapi.co/api/v2/pokemon/"+parseInt((Math.random()*720).toFixed(0))+"/",
"http://pokeapi.co/api/v2/pokemon/"+parseInt((Math.random()*720).toFixed(0))+"/"];

 urls.forEach(url => {

  fetch(url)
   .then(response => response.json())
    .then(json => {
      console.log(json);
       console.log(json.sprites.front_default);

       let div = document.getElementById('detalhesPokemon');
       let img = document.createElement('img');
       img.src = json.sprites.front_default;

       div.append(img);
})})
}


  })
