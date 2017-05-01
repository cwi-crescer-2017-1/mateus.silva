import java.util.ArrayList;
public class GuerraEntreExercitos{
    private ArrayList <Saint> exercitoOrdemAlternada, exercitoOrdemHierarquica;
    int vencedor = 0;
    public GuerraEntreExercitos (ArrayList <Saint> exercitoOrdemHierarquica, ArrayList <Saint> exercitoOrdemAlternada){
        this.exercitoOrdemHierarquica = exercitoOrdemHierarquica;
        this.exercitoOrdemAlternada = exercitoOrdemAlternada;
    }
    
    public void comecarGuerra (){
        for (int i = 0; i<exercitoOrdemAlternada.size();i++) {
             Saint hierarquica = exercitoOrdemHierarquica.get(i);
             Saint alternada = exercitoOrdemAlternada.get(i);
             Batalha guerra = new Batalha (hierarquica, alternada);
             guerra.iniciar();
             boolean saintOrdemHierarquicaMorreu = hierarquica.getStatus() == Status.MORTO;
             boolean alternada1 = alternada.getStatus() == Status.MORTO;
            if (saintOrdemHierarquicaMorreu){
                 vencedor++;
                }
                else{
                 vencedor--;
            }
        }
    }
    
    public boolean vencedorEhDaOrdemHierarquica (){
        boolean hierarquicaVenceu = false; 
        if (vencedor<0){
            hierarquicaVenceu = true;
        }
        return  hierarquicaVenceu;
    }
    
      public boolean vencedorEhDaOrdemAlternada (){
        boolean alternadaVenceu = false; 
        if (vencedor>0){
            alternadaVenceu = true;
        }
        return  alternadaVenceu;
    }
}