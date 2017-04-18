import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ConstelacaoTest {
    @Test
    public void aoAdicionarGolpeEleVaiParaOFinalDoArray() throws Exception{
        Constelacao virgem = new Constelacao ("Virgem");
        GoldSaint shaka = new GoldSaint ("Shaka", new Armadura (virgem, Categoria.OURO));
        Golpe golpe1 = new Golpe ();
        Golpe golpe2 = new Golpe ();
        Golpe golpe3 = new Golpe ();
        virgem.adicionarGolpe(golpe1);
        assertEquals(virgem.getGolpes()[2],golpe1);
        virgem.adicionarGolpe(golpe2);
        assertEquals(virgem.getGolpes()[2],golpe2);
        assertEquals(virgem.getGolpes()[1],golpe1);
        virgem.adicionarGolpe(golpe3);
        assertEquals(virgem.getGolpes()[2],golpe3);
        assertEquals(virgem.getGolpes()[0],golpe1);
        assertEquals(virgem.getGolpes()[1],golpe2); 
    }
}