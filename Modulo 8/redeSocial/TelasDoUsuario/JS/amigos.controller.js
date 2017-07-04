modulo.controller("AmigosController", function ($scope, amigosService,  feedService, authService){
var usuarioLogado = authService.getUsuario().username;
userGet(usuarioLogado);

$scope.add = add;
$scope.situacao = situacao;
$scope.situacaoStatus = [];
$scope.aceitar=aceitar;
$scope.logout = authService.logout;
$scope.getUsuariosPorNome = getUsuariosPorNome;
$scope.getUsuariosPorEsporte = getUsuariosPorEsporte;



function getUsuariosPorNome(nome){
  amigosService.getUsuariosPorNome(nome).then(function(response){
    $scope.usuarios = response.data;

  })}

  function getUsuariosPorEsporte(esporte){
    amigosService.getUsuariosPorEsporte(esporte).then(function(response){
      $scope.usuarios = response.data;
})}

  function userGet(usuarioLogado){
    feedService.userGet(usuarioLogado).then(function(response){
      $scope.user = response.data;
  })};


  function add(id){
    amigosService.add(id).then(function(response){
      getUsuariosPorNome($scope.nome)
      getUsuariosPorEsporte($scope.esporte)
  })};

loadAmigos();

function loadAmigos(){
  amigosService.loadAmigos().then(function (response) {
     $scope.amigos = response.data;
  } )
}

function aceitar(id){
  feedService.aceitar(id).then(function(response){
    getUsuariosPorNome($scope.nome)
    getUsuariosPorEsporte($scope.esporte)
})
  };

function situacao (id){
   amigosService.situacao(id)
    .then(function (response){
      $scope.situacaoStatus[id] = response.data;
      return response.data;
   })
}
})
