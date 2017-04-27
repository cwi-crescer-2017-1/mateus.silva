public class AtaqueDuplo implements Movimento{
    private Saint golpeador,golpeado;
    
    public AtaqueDuplo(Saint golpeador, Saint golpeado ){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar() {
       Dado3 dado = new Dado3();
       int numeroSorteado = dado.sortear();
       Golpear golpear = new Golpear (golpeador, golpeado);
       if (numeroSorteado==3){
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