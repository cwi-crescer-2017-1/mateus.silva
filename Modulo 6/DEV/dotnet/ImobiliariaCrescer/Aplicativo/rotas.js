modulo.config(function($routeProvider) {
    $routeProvider
      .when ("/login", {
        templateUrl: "/login/login.html",
        controller: "LoginController"
        })
      .when ("/informaOCliente", {
        templateUrl: "telas.do.usuario/informa.o.cliente.html",
        controller: "InformaOClienteController",
        resolve: {
        autenticado: function (authService) {
         return authService.isAutenticadoPromise();
      }
       }
      })
      .otherwise("/login");
});
