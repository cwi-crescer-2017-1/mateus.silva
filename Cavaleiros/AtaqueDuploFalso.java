public class AtaqueDuploFalso implements Movimento{
    private Saint golpeador,golpeado;
    private int valor; 
    public AtaqueDuploFalso(Saint golpeador, Saint golpeado ){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }  
    public int testar (int valor){
        return this.valor=valor;
    }    
    public void executar() {
       Golpear golpear = new Golpear (golpeador, golpeado);
       if (valor==3){
            double vidaAntesDoGolpe = golpeado.getVida();
            golpear.executar();
            double vidaDepoisDoGolpe = golpeado.getVida();
            double fatorDano = vidaAntesDoGolpe - vidaDepoisDoGolpe;
            golpeado.perderVida(fatorDano);
       }
       else {
            double  perde5Porcento =  golpeador.getVida()*0.05;
            golpeador.perderVida(perde5Porcento);
            golpear.executar(); 
       }   
    }
}