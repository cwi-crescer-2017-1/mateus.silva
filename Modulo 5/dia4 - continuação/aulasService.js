modulo.factory('aulaService', function ($http) {

  let urlBase = "http://localhost:3000";

  function getTodasAsAulas() {
    return $http.get(urlBase + '/aula');
  };

  function atualizar(aula) {
    console.log(aula);

  return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
  };

  function criar(aula) {
   return $http.post(urlBase + '/aula', aula);
};

  function remover (aula){
     return $http.delete(urlBase+'/aula'+'/'+aula.id)
  };

  return {
    list: getTodasAsAulas,
    update: atualizar,
    create: criar,
    deleteClass: remover
  };
});


// app.js para config
// segmentar arquivo
//nome/instrutor/aula e email(caso seja o mesmo) e poder excluir usuario = nao precisa fazer validacao
// colocar disable cache
// sucesso quando está dentro do then
//toastr alertas
