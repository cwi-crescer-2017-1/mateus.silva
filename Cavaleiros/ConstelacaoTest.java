import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ConstelacaoTest {
    @Test
    public void aoAdicionarGolpeEleVaiParaOFinalDoArray() throws Exception{
        Constelacao virgem = new Constelacao ("Virgem");
        GoldSaint shaka = new GoldSaint ("Shaka", new Armadura (virgem, Categoria.OURO));
        Golpe golpe = new Golpe ();
        virgem.adicionarGolpe(golpe);
        assertEquals(virgem.getGolpes()[2],golpe);
    }
}