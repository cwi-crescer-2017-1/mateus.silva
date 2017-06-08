modulo.config(function($routeProvider) {
    $routeProvider
      .when ("/login", {
        templateUrl: "/login/login.html",
        controller: "LoginController"
        })
        .when ("/clientes/:Id", {
          templateUrl: "/telas.do.usuario/escolha.do.produto.html",
          controller: "EscolhaDoProdutoController"
        })
        .when ("/cadastro", {
          templateUrl: "/telas.do.usuario/cadastro.html",
          controller: "cadastroController"
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
