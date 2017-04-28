public class ContraAtaqueFalso implements Movimento {
    private Saint golpeador, golpeado;
    private int valor; 
    public ContraAtaqueFalso (Saint golpeador, Saint golpeado){
      this.golpeador = golpeador;
      this.golpeado = golpeado;       
    }
      public int testar (int valor){
        return this.valor=valor;
    }    
    public void executar (){
        double vidaGolpeado = this.golpeado.getVida();
        boolean armaduraVestida = !(this.golpeado.getArmaduraVestida());
        boolean executaContraAtaque = (vidaGolpeado<50 && armaduraVestida); 
        if (executaContraAtaque){
            Golpear golpear = new Golpear (golpeador, golpeado);
            if (valor!=3){ 
                 double perde25Porcento = this.golpeador.getVida()*(0.25);
                 this.golpeador.perderVida(perde25Porcento);
                 this.golpeador.setAtaca(false);
                 boolean golpeadorPulaAtaque =this.golpeado.getValorDaCategoria () >= this.golpeador.getValorDaCategoria ();
               if (golpeadorPulaAtaque){
                     this.golpeador.setAtaca(true);                 
               }     
            }
       } 
     }
    }