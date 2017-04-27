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



/*
O golpeador tem 33.3% de chance de desferir um ataque com o dobro do dano 
(que deve seguir as regras normais de dano, já implementadas previamente).
Caso o golpeador não consiga desferir o ataque duplo (ou seja, estiver fora dos 33.3%), 
ele deve desferir um ataque normalmente mas perde 5% de vida. Quando o Saint 
tiver menos que 1 de vida ele morre (exemplo: 0.99 de vida já é considerado morto).*/