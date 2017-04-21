import java.util.ArrayList;
public abstract class Saint{
    private String nome;
    protected  Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO; 
    private double vida = 100.;
    protected  int qtsSentidosDespertados = 5;
    private int acumuladorProximoGolpe =0;
    private String nomeDaConstelacao; 
    public Saint (String nome, String nomeDaConstelacao) throws Exception{
      this.nome = nome;
      this.nomeDaConstelacao = nomeDaConstelacao;
    }
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }    
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }     
    public Genero getGenero(){
        return this.genero;
    }
    public void setGenero (Genero genero){
        this.genero = genero;
    }
    public Status getStatus(){
        return this.status;
    }
    public void perderVida(double dano) {
        if (dano<0){
            // erro
            throw new java.security.InvalidParameterException ();
        }
        else {
            if (getStatus() != status.MORTO){
            this.vida = this.vida -dano;
             }
             if (getVida()<1){
            this.status = status.MORTO;
            this.vida = 0;
            }
        }
    }
     public double getVida(){
        return this.vida;
    }
    public int getValorDaCategoria (){
        int valorDaCategoria = armadura.getValorDaCategoria();
        return valorDaCategoria;
    }
        public String getNome(){
        return this.nome;
    }
    public int getQtsSentidosDespertados(){
        return this.qtsSentidosDespertados;
    }
    public ArrayList <Golpe>  getGolpes(){
        return this.armadura.getConstelacao().getGolpes();
    }
    public void aprenderGolpe(Golpe golpe) {
        this.armadura.getConstelacao().adicionarGolpe(golpe);
    }
    public Golpe getProximoGolpe(){
        ArrayList <Golpe> golpes = getGolpes();
        int posicao = this.acumuladorProximoGolpe % golpes.size();
        this.acumuladorProximoGolpe++;
        return golpes.get(posicao);
    }
     public String getCSV(){
        String csv= "";
        csv +=
           this.nome + ","+
           this.vida +","+
           this.armadura.getConstelacao().getNomeDaConstelacao()+ ","+
           this.armadura.getValorStringDaCategoria() + ","+
           this.status+ ","+
           this.genero + ","+
           this.armaduraVestida;
        return csv;
    }
    public Armadura getArmadura(){
        return this.armadura;
    }
}