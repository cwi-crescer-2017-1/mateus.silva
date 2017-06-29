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
        templateUrl: "/feed.html",
        controller: "FeedController"
         })
        .otherwise("/login");
      });
