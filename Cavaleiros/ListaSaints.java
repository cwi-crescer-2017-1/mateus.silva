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
         this.ordenar(TipoOrdenacao.ASCENDENTE);
    }
    public void ordenar (TipoOrdenacao tipoOrdenacao){
        boolean ascendente =  TipoOrdenacao.ASCENDENTE == tipoOrdenacao;
        boolean  posicoesSendoTrocadas;
        do{
           posicoesSendoTrocadas = false;
           for (int i = 0; i<listaSaint.size()-1; i++){
               Saint saintAtual =  this.listaSaint.get(i);      
               Saint saintProximo = this.listaSaint.get(i+1);
               if(ascendente ? saintAtual.getVida() > saintProximo.getVida() :
                  saintAtual.getVida() < saintProximo.getVida()){
                  this.listaSaint.set(i,saintProximo);
                  this.listaSaint.set(i+1, saintAtual); 
                  posicoesSendoTrocadas = true;
               }
           }  
        } while (posicoesSendoTrocadas);
    }
    public ArrayList <Saint> unir (ArrayList <Saint>  lista){
        ArrayList <Saint> novaListaSaint = new ArrayList();
        int tamanhoDaLista1 = listaSaint.size();
        for (int i = 0 ; i<listaSaint.size();i++){
            Saint atual = listaSaint.get(i);
            novaListaSaint.add(i,atual);
        }
        for (int i = 0 ; i<lista.size();i++) {
            Saint atual = lista.get(i);
            novaListaSaint.add(tamanhoDaLista1 + i,atual);
        }
        return novaListaSaint;
    }
    public ArrayList<Saint> diff (ArrayList <Saint>  lista){
        ArrayList <Saint> novaListaSaint = new ArrayList();
        novaListaSaint = listaSaint;
        for (int i = 0 ; i<novaListaSaint.size();i++) {
            Saint atual = novaListaSaint.get(i);
            boolean igual = false;
            for (int a = 0 ; a<lista.size ();a++){
               if (atual.equals(lista.get(a))){
                   igual = true;
                   break;
                } 
            }
            if (igual == true){
                 novaListaSaint.remove(atual);
                 i--;
            }        
        }
        return novaListaSaint;
        
        /*  novaListaSaint = unir (lista); 
        for (int i = 0 ; i<novaListaSaint.size();i++){ 
            Saint atual = novaListaSaint.get(i);
            for (int a = 0; a <listaSaint.size();a++){ 
                if(atual.equals(this.listaSaint.get(a))){ 
                   novaListaSaint.remove(atual);
                }
            } 
        }
        return novaListaSaint;
        */
     }
    public ArrayList<Saint> intersec (ArrayList <Saint>  lista){
        ArrayList <Saint> novaListaSaint = new ArrayList();
        for (int i = 0 ; i<lista.size();i++) {
            Saint atual = lista.get(i);
            boolean igual = false;
            for (int a = 0 ; a<listaSaint.size ();a++){
               if (atual.equals(listaSaint.get(a))){
                   igual = true;
                   break;
                } 
            }
            if (igual == true){
                 novaListaSaint.add(atual);}
                    }
        return novaListaSaint;
    }
     public String getCSV() {
        if (this.listaSaint.isEmpty()) {
            return "";
        }
        String separador = System.getProperty("line.separator");
        StringBuilder builder = new StringBuilder(512);
        builder.append(this.listaSaint.get(0).getCSV());
        for (int i = 1; i < this.listaSaint.size(); i++) {
            Saint saint = this.listaSaint.get(i);
            builder.append(separador);
            builder.append(saint.getCSV());
        }
        return builder.toString();
    }
} 