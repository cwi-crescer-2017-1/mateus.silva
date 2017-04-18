public class Constelacao {
    private String nome;
    private int []golpes;
    public Constelacao (String nome){
        this.nome = nome;
    }
        public void adicionarGolpe(int golpe){
        golpes = new int[golpe];
    }
    public int[] getGolpes (){
        return this.golpes; 
    }
    public String getNomeDaConstelacao(){
        return this.nome;
    }
}