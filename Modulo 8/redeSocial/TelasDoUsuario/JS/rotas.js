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
       .when ("/editarPerfil", {
         templateUrl: "editar.perfil.html",
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
       .when ("/amigos", {
         templateUrl: "amigos.html",
         controller: "AmigosController",
         resolve: {
         autenticado: function (authService) {
          return authService.isAutenticadoPromise();
       }
        }
      })
      .when ("/amigoPerfil/:id", {
        templateUrl: "/amigoPerfil.html",
        controller: "amigoPerfilController",
           resolve: {
        autenticado: function (authService) {
         return authService.isAutenticadoPromise();
      }
       }
     })
        .otherwise("/login");
      });
