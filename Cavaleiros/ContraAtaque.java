public class ContraAtaque implements Movimento {
    private Saint golpeador, golpeado;
    public ContraAtaque (Saint golpeador, Saint Golpeado){
      this.golpeador = golpeador;
      this.golpeado = golpeado;     
    }
    public void executar (){
       double vidaGolpeado = this.golpeado.getVida();
       boolean armaduraVestida = this.golpeado.getArmaduraVestida();
       Dado3 dado = new Dado3();
       int numeroSorteado = dado.sortear();
       boolean executaContraAtaque = (vidaGolpeado<50 && armaduraVestida);
        if (executaContraAtaque){
            Golpear golpear = new Golpear (golpeador, golpeado);
            if (numeroSorteado!=3){ 
                 double perde25Porcento = this.golpeador.getVida()*(0.25);
                 this.golpeador.perderVida(perde25Porcento);
                 this.golpeador.setAtaca(false);
                 boolean golpeadorPulaAtaque = this.golpeado.getValorDaCategoria () >= this.golpeador.getValorDaCategoria ();
                 if (golpeadorPulaAtaque){
                    this.golpeador.setAtaca(true);                 
                 } 
            }     
       }
    }    
}