public class Constelacao {
    private String nome;
    private Golpe []golpes = new Golpe [3];
    public Constelacao (String nome){
        this.nome = nome;
    }
    public void adicionarGolpe(Golpe golpe){
        golpes [2]  = golpe;
    }
    public Golpe[] getGolpes (){
        return this.golpes; 
    }
    public String getNomeDaConstelacao(){
        return this.nome;
    }
}