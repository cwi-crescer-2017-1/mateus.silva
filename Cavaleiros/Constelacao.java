public class Constelacao {
    private String nome;
    private Golpe []golpes = new Golpe [3];
    public Constelacao (String nome){
        this.nome = nome;
    }
    public void adicionarGolpe(Golpe golpe){
        if (golpes [2] == null){
        golpes [2]  = golpe;}
        else {
             if (golpes [1] == null){
                golpes [1] = golpes [2];
                golpes [2]  = golpe;
            }
            else {
                if (golpes [0] == null){
                golpes [0] = golpes [1];
                golpes [1] = golpes [2];
                golpes [2]  = golpe;
            }
            }
        }
    }
    public Golpe[] getGolpes (){
        return this.golpes; 
    }
    public String getNomeDaConstelacao(){
        return this.nome;
    }
}