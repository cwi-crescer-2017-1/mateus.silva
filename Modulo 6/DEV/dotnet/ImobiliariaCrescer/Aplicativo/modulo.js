var modulo = angular.module ("myApp",["ngRoute","auth", "toastr"]);
angular.module("myApp").constant("authConfig", {

    urlUsuario: "http://localhost:63184/api/acessos/usuario",

    urlLogin: "/login",

    urlPrivado: "/informaOCliente",

    urlLogout: "/login"
});
