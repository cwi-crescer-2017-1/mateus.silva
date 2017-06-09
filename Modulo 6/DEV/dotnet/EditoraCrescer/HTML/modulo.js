var modulo = angular.module ("myApp", ["ngRoute", "auth",  "toastr","ui.bootstrap"]);

angular.module("myApp").constant("authConfig", {

    urlUsuario: 'http://localhost:52372/api/acessos/usuario',

    urlLogin: '/login',

    urlPrivado: '/crud',

    urlLogout: '/livros'

});
