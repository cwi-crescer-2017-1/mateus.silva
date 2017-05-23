modulo.factory('aulaService', function ($http) {

  let urlBase = "http://localhost:3000";

  function getTodasAsAulas() {
    return $http.get(urlBase + '/aula');
    //retorna uma promise/ nunca o valor
  };


  function getAulaPorId(id) {
    return $http.get(urlBase + '/aula' + '/' + id);
  };

  function atualizar(aula) {
  //  return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
  return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
  };

  function criar(aula) {
    //aula.id = ++idAtual;
    console.log(aula)
     $http.post(urlBase + '/aula', aula);
};

  // function remover (aula){
  //   return $http.delete(urlBase+'/aula'+'/'+aula.id, aula)
  // };



  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar
  //  delete: remover
  };
});


// app.js para config
// segmentar arquivo
//nome e email poder excluir usuario = nao precisa fazer validacao
// colocar disable cache
