public class Armadura{
    private Constelacao constelacao;
    private Categoria categoria;
    public Armadura (Constelacao constelacao, Categoria categoria){
        this.constelacao = constelacao;
        this.categoria = categoria;
    }
    public Constelacao getConstelacao(){
        return this.constelacao;
    }
    public int getValorDaCategoria (){
        int valorDaCategoria = categoria.getValor();
        return valorDaCategoria;
    } 
}