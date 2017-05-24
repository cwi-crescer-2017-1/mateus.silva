modulo.factory('instrutoresService', function ($http) {

  let urlBase = "http://localhost:3000/instrutor";

  function getTodosOsInstrutores() {
    return $http.get(urlBase);
  };

 function atualizar(instrutor) {
  return $http.put(urlBase + "/" +instrutor.id, instrutor);
 };

  function criar(instrutor) {
  return $http.post(urlBase, instrutor);
};

  function remover (instrutor){
     return $http.delete(urlBase+'/'+instrutor.id)
  };

  return {
    list: getTodosOsInstrutores,
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
