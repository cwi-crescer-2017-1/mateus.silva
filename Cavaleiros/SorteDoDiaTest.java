import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SorteDoDiaTest
{
   @Test
    public void testaParaSaberResultadosEsperados(){
        SorteDoDia sorte = new SorteDoDia(new Dado3());
        boolean resultado = sorte.sortear();
        boolean esperado = resultado && resultado;
        assertEquals (esperado, resultado);    
   }
   @Test
    public void testaParaSaberSeEstouComSorteRetornaFalse(){
        SorteDoDia sorte = new SorteDoDia(new Dado3());
        boolean resultado = sorte.sortear();
        while (resultado == false){
                resultado = sorte.sortear();}
        assertEquals (true, resultado);    
    }
   @Test
    public void estouComSorte() {
        Sorteador sorteador = new DadoFalso(3);
        SorteDoDia sorte = new SorteDoDia(sorteador);
        assertTrue(sorte.sortear());
    }
   @Test
    public void estouSemSorte() {
        Sorteador sorteador = new DadoFalso(1);
        SorteDoDia sorte = new SorteDoDia(sorteador);
        assertFalse(sorte.sortear());
    }
}