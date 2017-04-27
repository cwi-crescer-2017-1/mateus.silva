public class ContraAtaque implements Movimento {
    Saint golpeador, golpeado;
    
    public ContraAtaque (Saint golpeador, Saint Golpeado){
      this.golpeador = golpeador;
      this.golpeado = golpeado;       
    }
    
    public void executar (){
        double vidaGolpeado = golpeado.getVida();
        boolean armaduraVestida = golpeado.getArmaduraVestida();
        Dado3 dado = new Dado3();
        int numeroSorteado = dado.sortear();
        if (vidaGolpeado<50 && armaduraVestida==false){
            Golpear golpear = new Golpear (golpeador, golpeado);
       if (numeroSorteado==3){ 
            golpear.executar();
       }
       else {
            double perde25Porcento = golpeador.getVida()*(25/100);
            golpeador.perderVida(perde25Porcento);
       }     
    }
} 
    
}
/*Implemente um Movimento de contra-ataque que siga a regra abaixo:

Recebe o golpeador e o golpeado no construtor.
Caso o golpeado tenha menos da metade da vida e esteja sem armadura, 
ele tem 66.6% de chance de, no próximo ataque que tentarem desferir 
contra ele, não sofrer dano e ainda aplicar um ataque simples 
(sem regras de categoria, etc)
no adversário que tira 25% da vida. Altere classes caso necessário.*/