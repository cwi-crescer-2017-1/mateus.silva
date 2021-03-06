modulo.config(function($routeProvider) {
    $routeProvider
      .when ("/livros", {
        templateUrl: "/livros/livros.html",
        controller: "LivrosController"
      })
      .when ("/detalhe/:isbn", {
        templateUrl: "/livros/detalhe.html",
        controller: "LivroDetalheController"
      })
      .when ("/login", {
        templateUrl: "/login/login.html",
        controller: "LoginController"
      })
      .when ("/registrar", {
        templateUrl: "/login/registrar.html",
        controller: "RegistrarController"
      })
      .when ("/crud", {
        templateUrl: "/crud/crud.html",
        controller: "CrudController",
        resolve: {
        autenticado: function (authService) {
         return authService.isAutenticadoPromise();
       }
     }
      })
      .otherwise("/livros");
});
