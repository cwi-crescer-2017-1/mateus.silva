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
      .otherwise("/livros");
});
