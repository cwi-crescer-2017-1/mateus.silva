modulo.config(function($routeProvider){
     $routeProvider
     .when ("/aula", {
       templateUrl: "aula.html", controller: "AulaController"})
      .when ("/instrutores", {
      templateUrl: "instrutores.html", controller:"InstrutoresController"}).otherwise({redirectTo:"/index"})
});
