import java.util.ArrayList;

public class ExercitoQueAtacaEmOrdemHierarquica implements Exercito{
      private ArrayList <Saint> exercito = new ArrayList();
     
     public void alistar (Saint saintConvocado){
        exercito.add(saintConvocado);
     }
     public  ArrayList <Saint> ordenar(){
        boolean posicoesSendoTrocadas;
         do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i<exercito.size()-1; i++){
                Saint atual  = exercito.get(i);
                Saint proximo  = exercito.get(i+1);
                if (atual.getValorDaCategoria()>proximo.getValorDaCategoria()){
                    this.exercito.set(i,proximo);
                    this.exercito.set(i+1, atual); 
                     posicoesSendoTrocadas = true;
                }
            }  
        }while (posicoesSendoTrocadas);
         return exercito;
     }
}
