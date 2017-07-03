modulo.controller("FeedController", function ($scope, feedService, authService){
email();
userGet(usuarioLogado);
getUsuarios();
$scope.postar =postar;
getPosts();
$scope.aceitar = aceitar;
$scope.recusar =recusar;
$scope.curtir = cutir;
$scope.editar = editar;
$scope.logout = authService.logout;
var usuarioLogado;
var idUsuarioLogado;

function email (){
  usuarioLogado = JSON.parse(window.localStorage.getItem("ngStorage-usuarioLogado")).username;
};

function cutir (idPost){
  var curtida = {id: 1,idUsuario: $scope.user.id, id_post: idPost };
  feedService.cutir(curtida).then(function (response){
  $scope.cutiu = response.data;
 })
};

function userGet(usuarioLogado){
  feedService.userGet( usuarioLogado).then(function(response){
  $scope.user = response.data;
  idUsuarioLogado=    response.data.id;
  solicitacoes(idUsuarioLogado);
})};

function postar(postagem){
  var post = {id: 1, usuario: $scope.user, conteudo: postagem};
  console.log(post);
  feedService.postar(post).then(function(response){
  $scope.postagemDoUsuario = response.data;
  getPosts();
})}

function getPosts(){
  feedService.getPosts().then(function(response){
  $scope.posts = response.data;
})}


function getUsuarios(){
  feedService.getUsuarios().then(function(response){
  $scope.usuarios = response.data;
})}

function solicitacoes(idUsuarioLogado){
  feedService.solicitacoes(idUsuarioLogado).then(function(response){
  $scope.solicitacoesPendentes = response.data;
})}

function aceitar(id){
  userGet(usuarioLogado);
  feedService.aceitar(idUsuarioLogado, id).then(function(response){
})};

function recusar(id){
  userGet(usuarioLogado);
  feedService.recusar(idUsuarioLogado, id).then(function(response){
})}

function editar (usuario){
  console.log(usuario);
  feedService.editar(usuario).then(function(response){
})};

});
