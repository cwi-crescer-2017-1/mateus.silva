var modulo = angular.module ("myApp", ["ngRoute", "auth"]);

angular.module("myApp").constant("authConfig", {

    urlUsuario: 'http://localhost:52372/api/acessos/usuario',

    urlLogin: '/login',

    urlPrivado: '/crud',

    urlLogout: '/livros'
});
