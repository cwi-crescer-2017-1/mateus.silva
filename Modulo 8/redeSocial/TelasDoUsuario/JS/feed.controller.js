modulo.controller("FeedController", function ($scope, feedService, authService){
email();
userGet(usuarioLogado);
getUsuarios();
$scope.postar =postar;
getPosts();
$scope.aceitar = aceitar;
$scope.logout = authService.logout;
var usuarioLogado;
var idUsuarioLogado;

function email (){
    usuarioLogado = JSON.parse(window.localStorage.getItem("ngStorage-usuarioLogado")).username;

  };

function userGet(usuarioLogado){
  feedService.userGet( usuarioLogado).then(function(response){
      $scope.user = response.data;
      idUsuarioLogado=    response.data.id;
      solicitacoes(idUsuarioLogado);
})
};

function postar(postagem){
  var post = {idUsuario: $scope.user.id, conteudo: postagem, data: new Date()};
  feedService.postar(post).then(function(response){
    $scope.postagemDoUsuario = response.data;
    getPosts();
  })
}

function getPosts(){
  feedService.getPosts().then(function(response){
    $scope.posts = response.data;
  })
}


function getUsuarios(){
  feedService.getUsuarios().then(function(response){
    $scope.usuarios = response.data;
  })
}
function solicitacoes(idUsuarioLogado){
  feedService.solicitacoes(idUsuarioLogado).then(function(response){
  $scope.solicitacoesPendentes = response.data;
  })
  }

function aceitar(id){
  userGet(usuarioLogado);
  var solicitacao = {idRecebida: idUsuarioLogado, idEnviada:id}
  feedService.aceitar(idUsuarioLogado, id).then(function(response){

})

}

});
