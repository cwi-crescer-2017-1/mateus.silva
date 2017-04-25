import java.util.ArrayList;
public class Batalha {   
    private Saint saint1;
    private Saint saint2;
   public Batalha (Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
   public void iniciar(){
      int valor1 = this.saint1.getValorDaCategoria ();
      int valor2 = this.saint2.getValorDaCategoria();
      final double dano = 10;
      boolean saint1Ataca =false; 
      boolean saintsVivos = this.saint1.getStatus() != Status.MORTO && this.saint2.getStatus() != Status.MORTO;
      int saint1SemGolpe =  saint1.getGolpes().size();
      int saint2SemGolpe =  saint2.getGolpes().size();
      if (saintsVivos){
          if (valor1 >= valor2){
              saint2.perderVida(dano);
          }else {
              saint1.perderVida(dano);
              saint1Ataca =true;
          }  
      }
      if (saint1SemGolpe!=0 && saint2SemGolpe!=0){
          while (saintsVivos){
              if (saint1Ataca){
                  this.saint1.getProximoMovimento().executar();
                  saint1Ataca =false;
                }
                else {
                    this.saint2.getProximoMovimento().executar();
                    saint1Ataca =true;
                }
              saintsVivos = this.saint1.getStatus() != Status.MORTO && this.saint2.getStatus() != Status.MORTO;
          }
      }
   }
}