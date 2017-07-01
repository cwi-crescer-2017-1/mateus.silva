modulo.controller("FeedController", function ($scope, feedService, authService){
email();
$scope.logout = authService.logout;
var usuarioLogado;

function email (){
    usuarioLogado = JSON.parse(window.localStorage.getItem("ngStorage-usuarioLogado")).username;

  };

userGet(usuarioLogado);


function userGet(usuarioLogado){
  feedService.userGet( usuarioLogado).then(function(response){
      $scope.user =    response.data.email
})
};

});
