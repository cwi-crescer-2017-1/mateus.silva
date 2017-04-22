import java.util.ArrayList;
public abstract class Saint{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO; 
    private double vida = 100.;
    protected  int qtsSentidosDespertados = 5;
    private int acumuladorProximoGolpe =0;
    private int acumuladorProximoMovimento =0;
    private ArrayList <Movimento> movimento = new ArrayList <Movimento> ();
    public Saint (String nome, Armadura armadura) throws Exception{
      this.nome = nome;
      this.armadura = armadura;
       
      if (getValorDaCategoria() == 3){
         String constelacao = armadura.getConstelacao().getNomeDaConstelacao();
         if ( !constelacao.equals("Áries") 
            && !constelacao.equals("Touro")
            && !constelacao.equals("Gêmeos")
            && !constelacao.equals("Câncer")
            && !constelacao.equals("Virgem")
            && !constelacao.equals("Leão")
            && !constelacao.equals("Libra")
            && !constelacao.equals("Escorpião")
            && !constelacao.equals("Sagitário")
            && !constelacao.equals("Capricórnio")
            && !constelacao.equals("Aquário")
            && !constelacao.equals("Peixes")) {
            // dar erro
            throw new Exception("Constelação inválida");
           } 
        }
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
    public void adicionarMovimento (Movimento movimento){
        this.movimento.add(movimento);
    }
    public Movimento getProximoMovimento(){
        int posicao = this.acumuladorProximoMovimento % movimento.size();
        this.acumuladorProximoMovimento++;
        return movimento.get(posicao);
    }
}