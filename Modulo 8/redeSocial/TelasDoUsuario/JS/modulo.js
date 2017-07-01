var modulo = angular.module ("myApp", ["ngRoute", "auth", "toastr"]);

angular.module("myApp").constant("authConfig", {

    urlUsuario: 'http://localhost:9090/api/usuario',

    urlLogin: '/login',

    urlPrivado: '/feed',

    urlLogout: '/login'

});
