var modulo = angular.module('data', []);
modulo.controller('controller1', function($scope) {
$scope.imprime = function () {

    $scope.data = new Date ($scope.date);
}
});
