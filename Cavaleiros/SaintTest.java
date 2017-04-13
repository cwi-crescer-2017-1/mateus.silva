

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida(){
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura touro = new Armadura ("Touro", Categoria.OURO);
        Saint personagem = new Saint ("Lala", touro);
        // 2. Act  - Invocar a ação a  ser testada 
        personagem.vestirArmadura();
        // 3. Assert ´- Verificação dos resultados do teste
        boolean resultado = personagem.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmarduraDeixaArmaduraNaoVestida(){
        Saint k = new Saint ("Hyoga", new Armadura ("Cisne", Categoria.BRONZE));
        assertEquals (false, k.getArmaduraVestida());
    }
    @Test
    public void aoCriarSaintGeneroENaoInformado(){
        Armadura virgem = new Armadura ("virgem", Categoria.OURO);
        Saint mu = new Saint ("Mú", virgem);
        assertEquals(Genero.NAO_INFORMADO, mu.getGenero());
    }
}
    