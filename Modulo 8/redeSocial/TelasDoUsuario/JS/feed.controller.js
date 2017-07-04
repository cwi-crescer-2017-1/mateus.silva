modulo.controller("FeedController", function ($scope, feedService, authService){
var usuarioLogado = authService.getUsuario().username;
userGet(usuarioLogado);
$scope.postar =postar;
getPosts();
$scope.aceitar = aceitar;
$scope.recusar =recusar;
$scope.curtir = cutir;
$scope.descurtir = descutir;
$scope.editar = editar;
$scope.naocurtiu=naocurtiu;
$scope.logout = authService.logout;
var idUsuarioLogado;

function cutir (idPost){
  var curtida = {id: 1,idUsuario: $scope.user.id, id_post: idPost };
  feedService.cutir(curtida).then(function (response){
  $scope.curtiu = response.data;
  getPosts();
 })
};

function descutir (curtidas){
  var curtida = curtidas.filter(function (curtiu){return curtiu.idUsuario ==$scope.user.id})[0].id;
  feedService.descutir(curtida).then(function (response){
  getPosts();
 })
};

function naocurtiu(curtidas){
  if (curtidas.filter(function (curtiu){return curtiu.idUsuario ==$scope.user.id}).length>0){
     return false;
    }
  else {
    return true;
  }
}

function userGet(usuarioLogado){
  feedService.userGet( usuarioLogado).then(function(response){
  $scope.user = response.data;
  idUsuarioLogado=    response.data.id;
  solicitacoes(idUsuarioLogado);
})};

function postar(postagem){
  var post = {id: 1, usuario: $scope.user, conteudo: postagem};
  feedService.postar(post).then(function(response){
  $scope.postagemDoUsuario = response.data;
  getPosts();
})}

function getPosts(){
  feedService.getPosts().then(function(response){
  $scope.posts = response.data;
})}

function solicitacoes(idUsuarioLogado){
  feedService.solicitacoes(idUsuarioLogado).then(function(response){
  $scope.solicitacoesPendentes = response.data;
})}

function aceitar(id){
  feedService.aceitar(id).then(function(response){
  solicitacoes(idUsuarioLogado);
})};

function recusar(id){
  userGet(usuarioLogado);
  feedService.recusar(idUsuarioLogado, id).then(function(response){
})}

function editar (usuario){
  feedService.editar(usuario).then(function(response){
})};

});
