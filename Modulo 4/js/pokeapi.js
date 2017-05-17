
document.addEventListener('DOMContentLoaded', function() {
  let btnPesquisar = document.getElementById('btnPesquisar');
  btnPesquisar.onclick = function() {
  a =  document.getElementById("pkmescolhido").value;

 let url =   "http://pokeapi.co/api/v2/pokemon/"+a+"/"

  fetch(url)
   .then(response => response.json())
    .then(json => {
      console.log(json);
       console.log(json.sprites.front_default);




       let div = document.getElementById('detalhesPokemon');
       let nome = document.getElementById('nome');
       let numero = document.getElementById('numero');
       let imagem = document.getElementById('imagem');
       let tipo = document.getElementById('tipo');
       let img = document.createElement('img');
       img.src = json.sprites.front_default;

       let arrayTypes = json.types;
       nome.append(json.name.toUpperCase());
       numero.append(json.id);
       imagem.append(img);
       arrayTypes.forEach( t => { tipo.append(t.type.name);})
    })
}
})
