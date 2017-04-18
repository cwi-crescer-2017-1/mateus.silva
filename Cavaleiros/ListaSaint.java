import java.util.ArrayList;
public class ListaSaint{
    private ArrayList <Saint> listaSaint = new ArrayList();
    public void adicionarSaint(Saint saint){
         this.listaSaint.add(saint);
    }
    public Saint get(int indice){
         return this.listaSaint.get(indice);
    }
 }