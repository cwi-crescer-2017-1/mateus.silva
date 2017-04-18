public  class Saint{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.;
    protected  int qtsSentidosDespertados = 5;
    public Saint (String nome, Armadura armadura) throws Exception{
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
    public void perderVida(double golpe) {
        if (golpe<0){
            // erro
            throw new java.security.InvalidParameterException ();
        }
        else {
            if (getStatus() != status.MORTO){
            this.vida = this.vida - golpe;
             }
             if (getVida()<1){
            this.status = status.MORTO;
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
    public Golpe [] getGolpes(){
        return armadura.getConstelacao().getGolpes();
    }
    public void aprenderGolpe(Golpe golpe) {
        armadura.getConstelacao().adicionarGolpe(golpe);
    }
    //public Golpe getProximoGolpe(){
    //    for (int indice = 0; indice < getGolpes().length; indice++){
    //    Golpe  proximoGolpe = getGolpes()[indice];
        //     if (indice ==2){
                 //  proximoGolpe = getGolpes() [0];}
            // else {
             //      proximoGolpe = getGolpes() [indice +1];}
            // return proximoGolpe;
             //     }
   // }
}