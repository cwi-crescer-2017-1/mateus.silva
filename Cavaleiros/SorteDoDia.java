public class SorteDoDia {
    
    private Sorteador sorteador;
    
    public SorteDoDia (Sorteador sorteador){
        this.sorteador = sorteador;
    }
    
    public boolean sortear(){
       int resultado = this.sorteador.sortear();
       return resultado % 3 == 0;
    }
}