import java.util.ArrayList;

public class ExercitoQueAtacaEmOrdemAlternada implements Exercito{
      private ArrayList <Saint> exercito = new ArrayList();
     
     public void alistar (Saint saintConvocado){
        exercito.add(saintConvocado);
     }
     public  ArrayList <Saint> ordenar(){
         ArrayList <Saint> novoExercito = new ArrayList();
         int c1 =0;
         int c2 =0;
         int c3 =0;
         int contador = 0;
         do {
             while (c1<exercito.size()){
               Saint saintAtual = exercito.get(c1);
               boolean categoria1 = saintAtual.getValorDaCategoria()==1;
               if (categoria1){
                   novoExercito.add(saintAtual);
                   contador++;
                   c1++;
                   break; 
               }
               c1++;
            }
            while (c2<exercito.size()){
                Saint saintAtual = exercito.get(c2);
                boolean categoria2 = saintAtual.getValorDaCategoria()==2;
                if (categoria2){
                    novoExercito.add(saintAtual);
                    contador++;
                    c2++;
                    break;
                }
                c2++;
            }
            while (c3<exercito.size()){
                Saint saintAtual = exercito.get(c3);
                boolean categoria3 = saintAtual.getValorDaCategoria()==3;
                if (categoria3){
                    novoExercito.add(saintAtual);
                    contador++;
                    c3++;
                    break;
                }
                c3++;
            }
         }while (contador<exercito.size());
         return novoExercito;
     }
}