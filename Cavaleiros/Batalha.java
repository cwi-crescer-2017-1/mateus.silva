public class Batalha {   
   public void iniciar (Saint saint1, Saint saint2){
       if (saint1.getValorDaCategoria () > saint2.getValorDaCategoria()){
           saint2.perderVida(10);
           System.out.println(saint1.getNome() +" (" +saint1.getValorStringDaCategoria() +") vs " +saint2.getNome() +" (" +saint2.getValorStringDaCategoria() +")");
           System.out.println ("Como "+saint1.getValorStringDaCategoria() + " é maior que " +saint2.getValorStringDaCategoria() +" "+saint2.getNome() + " deverá perder 10 de vida");
       }
       else if (saint1.getValorDaCategoria ()<saint2.getValorDaCategoria()){
           saint1.perderVida(10);
           System.out.println(saint1.getNome() +" (" +saint1.getValorStringDaCategoria() +") vs " +saint2.getNome() +" (" +saint2.getValorStringDaCategoria() +")");
           System.out.println ("Como "+saint2.getValorStringDaCategoria() + " é maior que " +saint1.getValorStringDaCategoria() +" "+saint1.getNome() + " deverá perder 10 de vida");
       }
       else {
           saint2.perderVida(10);
           System.out.println(saint1.getNome() +" (" +saint1.getValorStringDaCategoria() +") vs " +saint2.getNome() +" (" +saint2.getValorStringDaCategoria() +")");
           System.out.println ("Como "+saint1.getValorStringDaCategoria() + " é maior que " +saint2.getValorStringDaCategoria() +" "+saint2.getNome() + " deverá perder 10 de vida");
       }  
   }
}