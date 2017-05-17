
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
       let nome = document.createElement('p');
       nome.textContent = "Nome: " + json.name.toUpperCase();
       let numero = document.createElement('p');
       numero.textContent = "Número: " + json.id;
       let img = document.createElement('img');
       img.src = json.sprites.front_default;
       let ul = document.createElement('ul');
       ul.textContent = "Tipos";
       let li  = document.createElement('li');

       div.append(nome);
       div.append(numero);
       div.append(img);
       div.append(ul)
       ul.append(li)
       let arrayTypes = json.types;
       arrayTypes.forEach( t => {li.appendChild(document.createTextNode(t.type.name));})
       arrayStats = json.stats;
       console.log(arrayStats)
       arrayStats.forEach ( s => { var stats = document.createElement('p'); stats.textContent =  s.stat.name.toUpperCase(); div.append(stats);
              var barra = document.createElement('progress'); barra.value= s.base_stat; barra.max = 100; div.append(barra)  })
    })
}
})
