modulo.controller("FeedController", function ($scope, feedService, authService){
email();
getUsuarios();
$scope.postar =postar;
getPosts();
solicitacoes();
$scope.logout = authService.logout;
var usuarioLogado;
function email (){
    usuarioLogado = JSON.parse(window.localStorage.getItem("ngStorage-usuarioLogado")).username;

  };

userGet(usuarioLogado);


function userGet(usuarioLogado){
  feedService.userGet( usuarioLogado).then(function(response){
      $scope.user = response.data;
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
function solicitacoes (){
  feedService.solicitacoes().then(function(response){
    $scope.solicitacoesPendentes = response.data;
    console.log(  $scope.solicitacoesPendentes);
  })
  }

});
