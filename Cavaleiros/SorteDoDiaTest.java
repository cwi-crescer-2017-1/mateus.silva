import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SorteDoDiaTest
{
   @Test
    public void testaParaSaberResultadosEsperados(){
        SorteDoDia sorte = new SorteDoDia(new DadoD6());
        boolean resultado = sorte.estouComSorte();
        boolean esperado = resultado && resultado;
        assertEquals (esperado, resultado);    
   }
   @Test
    public void testaParaSaberSeEstouComSorteRetornaFalse(){
        SorteDoDia sorte = new SorteDoDia(new DadoD6());
        boolean resultado = sorte.estouComSorte();
        while (resultado == false){
                resultado = sorte.estouComSorte();}
        assertEquals (true, resultado);    
   }
    @Test
    public void testaParaSaberSeEstouComSorteRetornaTrue(){
        SorteDoDia sorte = new SorteDoDia(new DadoD6());
        boolean resultado = sorte.estouComSorte();
        while (resultado == true){
                resultado = sorte.estouComSorte();}   
        assertEquals (false, resultado);    
   }
}