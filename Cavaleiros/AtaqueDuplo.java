public class AtaqueDuplo implements Movimento{
    Saint golpeador,golpeado;
    
    public AtaqueDuplo(Saint golpeador, Saint golpeado ){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar() {
       DadoD6 dado = new DadoD6();
       dado=sortear();
       boolean ataqueDuplo = false;
       int fatorDano;
       if (dado<=2){
            ataqueDuplo = true;
            fatorDano = (golpeador.getProximoGolpe().getFatorDano())*2;
            golpeado.perderVida(fatorDano);
       }
       else {
            fatorDano = (golpeador.getProximoGolpe().getFatorDano());
            int  perde5Porcento =  golpeador.getVida()*5/100;
            golpeado.perderVida(fatorDano);
            golpeador.perdeVida(perde5Porcento);
            
       }
         
       // vai dar empate?
    }
}


/*
O golpeador tem 33.3% de chance de desferir um ataque com o dobro do dano 
(que deve seguir as regras normais de dano, já implementadas previamente).
Caso o golpeador não consiga desferir o ataque duplo (ou seja, estiver fora dos 33.3%), 
ele deve desferir um ataque normalmente mas perde 5% de vida. Quando o Saint 
tiver menos que 1 de vida ele morre (exemplo: 0.99 de vida já é considerado morto).*/