public class Batalha {   
    private Saint saint1;
    private Saint saint2;
   public Batalha (Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
   public void iniciar(){
      int turno =1; 
      if (this.saint1.getValorDaCategoria () >= this.saint2.getValorDaCategoria()){
           turno ++;
       }
      while (this.saint1.getStatus() == Status.VIVO && this.saint2.getStatus() == Status.VIVO){
             if (turno%2==0 ){
               this.saint1.getProximoMovimento().executar();
               turno++;
            }
            else {
               this.saint2.getProximoMovimento().executar();
               turno++;
            }
      }
   }
}
