public  class Saint{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100;
    public Saint (String nome, Armadura armadura){
      this.nome = nome;
      this.armadura = armadura;
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
    public void perderVida(double golpe){
        vida = vida - golpe;
    }
     public double getVida(){
        return this.vida;
    }
    public int getValorDaCategoria (){
        int valorDaCategoria = armadura.getValorDaCategoria();
        return valorDaCategoria;
    }
    public String getValorStringDaCategoria(){
        String valorString = armadura.getValorStringDaCategoria();
        return valorString;
    }
    public String getNome(){
        return this.nome;
    }
}