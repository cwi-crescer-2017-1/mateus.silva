import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class BatalhaTest{
     @Test 
    public void iniciaBatalhaSaint1Perde10()throws Exception{
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));
        Saint shion = new Saint ("Shion", new Armadura ("Áries", Categoria.OURO));
        Batalha b = new Batalha(seiya, shion);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (90, seiya.getVida(), delta );
    }
     @Test 
    public void iniciaBatalhaSaint2Perde10()throws Exception{
        Saint shion = new Saint ("Shion", new Armadura ("Áries", Categoria.OURO));
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));
        Batalha b = new Batalha( shion, seiya);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (90, seiya.getVida(), delta );
    }
     @Test 
    public void iniciaBatalhaComDoisCavaleirosDaMesmaCategoriaSegundoCavaleiroDevePerder10 ()throws Exception{
        Saint shion = new Saint ("Shion", new Armadura ("Áries", Categoria.OURO));
        Saint mu = new Saint ("Mu", new Armadura ("Touro", Categoria.OURO));
        Batalha b = new Batalha( shion, mu);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (90, mu.getVida(), delta );
    }
}