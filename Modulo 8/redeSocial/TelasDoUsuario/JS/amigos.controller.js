modulo.controller("AmigosController", function ($scope, amigosService,  feedService, authService){
email();
var usuarioLogado;
getUsuarios();
userGet(usuarioLogado);
$scope.add = add;
$scope.situacao = situacao;
$scope.situacaoStatus = [];
$scope.aceitar=aceitar;
$scope.logout = authService.logout;

function email (){
  usuarioLogado = JSON.parse(window.localStorage.getItem("ngStorage-usuarioLogado")).username;
};

function getUsuarios(){
  amigosService.getUsuarios().then(function(response){
    $scope.usuarios = response.data;
  })}

  function userGet(usuarioLogado){
    feedService.userGet(usuarioLogado).then(function(response){
    $scope.user = response.data;
  })};


  function add(id){
    amigosService.add(id).then(function(response){
      getUsuarios();
  })};

loadAmigos();
function loadAmigos(){
  amigosService.loadAmigos().then(function (response) {
     $scope.amigos = response.data;
  } )
}

function aceitar(id){
  feedService.aceitar(id).then(function(response){
})
    getUsuarios();};

function situacao (id){
   amigosService.situacao(id)
    .then(function (response){
      $scope.situacaoStatus[id] = response.data;
      return response.data;
   })
}
})
