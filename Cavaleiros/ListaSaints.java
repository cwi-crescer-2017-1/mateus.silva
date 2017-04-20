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
        if (listaSaint.isEmpty()){
            return null;
        }
        Saint saintComMaiorVida = this.listaSaint.get(0);
        for (int i = 1; i<listaSaint.size(); i++){
            Saint saint = this.listaSaint.get(i);
            if(saint.getVida() > saintComMaiorVida.getVida()){
                saintComMaiorVida = saint;
            }
        }
        return saintComMaiorVida;
    }
    public Saint getSaintMenorVida(){
         if (listaSaint.isEmpty()){
            return null;
        }
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
        boolean posicoesSendoTrocadas;    
        do{
            posicoesSendoTrocadas = false;
            for (int i = 0; i<listaSaint.size()-1; i++){
                Saint saintAtual =  this.listaSaint.get(i);      
                Saint saintProximo = this.listaSaint.get(i+1);
                if (saintAtual.getVida()>saintProximo.getVida()){
                    this.listaSaint.set(i,saintProximo);
                    this.listaSaint.set(i+1, saintAtual); 
                    posicoesSendoTrocadas = true;
                }
            }  
        } while (posicoesSendoTrocadas);
    }
    public void ordenar (TipoOrdenacao tipoOrdenacao){
         if (TipoOrdenacao.ASCENDENTE == tipoOrdenacao){
             ordenar();
        }
         else { 
             boolean  posicoesSendoTrocadas;
             do{
                 posicoesSendoTrocadas = false;
                 for (int i = 0; i<listaSaint.size()-1; i++){
                     Saint saintAtual =  this.listaSaint.get(i);      
                     Saint saintProximo = this.listaSaint.get(i+1);
                     if  (saintAtual.getVida()<saintProximo.getVida()){
                         this.listaSaint.set(i,saintProximo);
                         this.listaSaint.set(i+1, saintAtual); 
                         posicoesSendoTrocadas = true;
                      }
                 }  
             } while (posicoesSendoTrocadas);
        }
    }
    public ArrayList <Saint> unir (ArrayList <Saint>  lista){
        ArrayList <Saint> novaListaSaint = new ArrayList();
        int size = listaSaint.size();
        for (int i = 0 ; i<listaSaint.size();i++){
            Saint atual = listaSaint.get(i);
            novaListaSaint.add(i,atual);
        }
        for (int i = 0 ; i<lista.size();i++) {
            Saint atual = lista.get(i);
            novaListaSaint.add(size + i,atual);
        }
        return novaListaSaint;
    }
}
    //public ArrayList<Saint> intersec (ArrayList <Saint>  lista){
        
    //}
    
 //   Crie uma operação na classe ListaSaints chamada intersec que recebe um outra lista de
   // saints (ou seja...) e retorna uma nova ListaSaints com a interseção entre lista atual e a outra que foi informada.
