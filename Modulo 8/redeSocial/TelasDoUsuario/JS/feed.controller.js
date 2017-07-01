modulo.controller("FeedController", function ($scope, feedService, authService){
email();
$scope.postar =postar;
getPosts();
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
  })
}

function getPosts(){
  feedService.getPosts().then(function(response){
    $scope.posts = response.data;
  })
}


});
