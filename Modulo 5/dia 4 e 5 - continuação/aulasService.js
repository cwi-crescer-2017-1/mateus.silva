modulo.factory('aulaService', function ($http) {

  let urlBase = "http://localhost:3000";

  function getTodasAsAulas() {
    return $http.get(urlBase + '/aula');
  };

  function atualizarAula(aula) {
    console.log(aula);

  return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
  };

  function criarAula(aula) {
   return $http.post(urlBase + '/aula', aula);
};

  function removerAula (aula){
     return $http.delete(urlBase+'/aula'+'/'+aula.id)
  };

  return {
    listAula: getTodasAsAulas,
    updateAula: atualizarAula,
    createAula: criarAula,
    deleteAula: removerAula
  };
});


// app.js para config
// segmentar arquivo

//toastr alertas
