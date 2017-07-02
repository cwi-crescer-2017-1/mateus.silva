modulo.config(function($routeProvider) {
    $routeProvider
      .when ("/login", {
        templateUrl: "login.html",
        controller: "LoginController"
        })
       .when ("/cadastro", {
        templateUrl: "/cadastro.html",
        controller: "LoginController"
       })
       .when ("/feed", {
         templateUrl: "feed.html",
         controller: "FeedController",
         resolve: {
         autenticado: function (authService) {
          return authService.isAutenticadoPromise();
       }
        }
       })
       .when ("/perfil", {
         templateUrl: "perfil.html",
         controller: "FeedController",
         resolve: {
         autenticado: function (authService) {
          return authService.isAutenticadoPromise();
       }
        }
       })
       .when ("/buscar", {
         templateUrl: "buscar.html",
         controller: "FeedController",
         resolve: {
         autenticado: function (authService) {
          return authService.isAutenticadoPromise();
       }
        }
       })
        .otherwise("/login");
      });
