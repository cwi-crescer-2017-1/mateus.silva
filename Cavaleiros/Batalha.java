public class Batalha {   
    private Saint saint1;
    private Saint saint2;
   public Batalha (Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
   public void iniciar(){
      int turno =1; 
      final int  dano = 10;
      if (saint1.getValorDaCategoria () >= saint2.getValorDaCategoria()){
           saint2.perderVida(dano);
           turno ++;
       }
       else {
           saint1.perderVida(dano);
          
       }
      while (saint1.getStatus() == Status.VIVO && saint2.getStatus() == Status.VIVO){
             if (turno%2==0 ){
                saint1.perderVida(dano);
                turno++;
            }
            else {
               saint2.perderVida(dano);
               turno++;
            }
      }
   }
}
/*Altere a classe Batalha para, no método iniciar, 
enquanto nenhum Saint estiver morto alternar os movimentos 
a serem aplicados entre eles, simulando uma batalha por turnos.
 A lógica do ataque inicial deverá ser mantida.*/