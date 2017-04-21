public class Golpear implements Movimento {
    private Saint golpeador;
    private Saint golpeado;
    
    public Golpear (Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;       
    }
    
    public void executar (){
        int fatorDano = golpeador.getProximoGolpe().getFatorDano();
        if (golpeador.getArmaduraVestida() == true){
            fatorDano =  fatorDano* (1 + golpeador.getValorDaCategoria());
        }
         
        golpeado.perderVida(fatorDano);
    }   
}