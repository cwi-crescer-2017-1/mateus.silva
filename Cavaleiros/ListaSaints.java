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
    public ListaSaints unir (ListaSaints  lista){
        ArrayList <Saint> lista1 = lista.todos();
        ListaSaints novaListaSaint = new ListaSaints();
        for (int i = 0 ; i<listaSaint.size();i++){
            Saint atual = listaSaint.get(i);
            novaListaSaint.adicionar(atual);
        }
        for (int i = 0 ; i<lista1.size();i++) {
            Saint atual = lista1.get(i);
            novaListaSaint.adicionar(atual);
        }
        return novaListaSaint;
    }
     public ListaSaints diff (ListaSaints lista1){
        ArrayList <Saint> lista = lista1.todos();
        for (int i = 0 ; i<listaSaint.size();i++) {
            Saint atual = listaSaint.get(i);
            boolean igual = false;
            for (int a = 0 ; a<lista.size ();a++){
               if (atual.equals(lista.get(a))){
                   igual = true;
                   break;
                } 
            }
            if (igual == true){
                 listaSaint.remove(atual);
                 i--;
            }        
        }
        ListaSaints resultado = new ListaSaints();
        for (int i = 0 ; i<listaSaint.size();i++) {
            Saint atual = listaSaint.get(i);
            resultado.adicionar(atual);}
        return resultado;
    }
    public ListaSaints intersec (ListaSaints  lista){
         ArrayList <Saint> lista1 = lista.todos();
         ListaSaints resultado = new ListaSaints();
        for (int i = 0 ; i<lista1.size();i++) {
            Saint atual = lista1.get(i);
            boolean igual = false;
            for (int a = 0 ; a<listaSaint.size ();a++){
               if (atual.equals(listaSaint.get(a))){
                   igual = true;
                   break;
                } 
            }
            if (igual == true){
                 resultado.adicionar(atual);}
                    }
        return resultado;
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