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
