import java.util.Collection;
import java.util.ArrayList;

public class ListaSaints{
    private ArrayList <Saint> listaSaint = new ArrayList();
    public void adicionar(Saint saint){
         this.listaSaint.add(saint);
    }
    public Saint get(int indice){
         return this.listaSaint.get(indice);
    }
    public ArrayList<Saint> todos (){
        return this.listaSaint;
    } 
    public void remover (Saint saint){
        this.listaSaint.remove(saint);
    }
    public Saint buscarPorNome(String nome){
        for (int i = 0; i<listaSaint.size(); i++){
            Saint primeiroSaint = this.listaSaint.get(i); 
            if(primeiroSaint.getNome().equals(nome)){
                 return primeiroSaint;
            }
        }
        return null;
    }
    public ArrayList <Saint> buscarPorCategoria(Categoria categoria){
        ArrayList <Saint> subLista = new ArrayList();
        for (int i = 0; i<listaSaint.size(); i++){
            Saint subSaint = this.listaSaint.get(i); 
            if(subSaint.getValorDaCategoria() == categoria.getValor()){
                 subLista.add(subSaint);
            }
        }
        return subLista;
    }
    public ArrayList <Saint> buscarPorStatus (Status status){
         ArrayList <Saint> subLista = new ArrayList();
        for (int i = 0; i<listaSaint.size(); i++){
            Saint subSaint = this.listaSaint.get(i); 
            if(subSaint.getStatus() == status){
                 subLista.add(subSaint);
            }
        }
        return subLista;
    }
    public Saint getSaintMaiorVida(){
        Saint saintComMaiorVida = this.listaSaint.get(0);
        for (int i = 0; i<listaSaint.size(); i++){
            Saint saint = this.listaSaint.get(i);
            if(saint.getVida() > saintComMaiorVida.getVida()){
                saintComMaiorVida = saint;
            }
        }
        return saintComMaiorVida;
    }
    public Saint getSaintMenorVida(){
        Saint saintComMenorVida = this.listaSaint.get(0);
        for (int i = 0; i<listaSaint.size(); i++){
            Saint saint = this.listaSaint.get(i);
            if(saint.getVida() < saintComMenorVida.getVida()){
                 saintComMenorVida = saint;
            }
        }
        return saintComMenorVida;
    }
    public void ordenar (){
        for (int a = 1; a<listaSaint.size(); a++){
            Saint saintAntes;
            Saint saintDepois;
            Saint auxiliar;
            for (int i = 0; i<listaSaint.size()-a; i++){
                if (this.listaSaint.get(i).getVida()>this.listaSaint.get(i+1).getVida()){
                    auxiliar = this.listaSaint.get(i);
                    saintAntes = this.listaSaint.get(i+1);
               saintDepois = auxiliar; 
               this.listaSaint.set(i,saintAntes);
               this.listaSaint.set(i+1, auxiliar); 
            }
        }  
        }
    }
 }
        
        
 