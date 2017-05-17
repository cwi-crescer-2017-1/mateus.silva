Number.prototype.arredondar = function (numeroDeCasas){
    casas = numeroDeCasas || 2;
    return this.toFixed(casas);
}
console.log(45.66666.arredondar(3));
console.log(45.555555.arredondar())
