import java.util.ArrayList;
public class ListaSaint{
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
        ArrayList <Saint> subList = new ArrayList();
        for (int i = 0; i<listaSaint.size(); i++){
            Saint subSaint = this.listaSaint.get(i); 
            if(subSaint.getValorDaCategoria() == categoria.getValor()){
                 subList.add(subSaint);
            }
        }
        return subList;
    }
}