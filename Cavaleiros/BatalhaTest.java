import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class BatalhaTest{
     @Test 
    public void iniciaBatalhaSaint1Perde10()throws Exception{
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint shion = new GoldSaint ("Shion", "Áries");
        Batalha b = new Batalha(seiya, shion);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (0, seiya.getVida(), delta );
        assertEquals (10, shion.getVida(), delta );
    }
     @Test 
    public void iniciaBatalhaSaint2Perde10()throws Exception{
        Saint shion = new GoldSaint ("Shion", "Áries");
        Saint seiya = new BronzeSaint ("Seiya","Pégaso");
        Batalha b = new Batalha( shion, seiya);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (0, seiya.getVida(), delta );
        assertEquals (10, shion.getVida(), delta );
    }
     @Test 
    public void iniciaBatalhaComDoisCavaleirosDaMesmaCategoriaSegundoCavaleiroDevePerder10 ()throws Exception{
        Saint shion = new GoldSaint ("Shion", "Áries");
        Saint mu = new GoldSaint ("Mu", "Touro");
        Batalha b = new Batalha( shion, mu);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (0, mu.getVida(), delta );
        assertEquals (10, shion.getVida(), delta );
    }
        @Test 
    public void iniciaBatalhaComSaintsSemVida ()throws Exception{
        Saint shion = new GoldSaint ("Shion", "Áries");
        Saint mu = new GoldSaint ("Mu", "Touro");
        shion.perderVida(100);
        mu.perderVida(100);
        Batalha b = new Batalha( shion, mu);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (0, mu.getVida(), delta );
        assertEquals (0, shion.getVida(), delta );
    }
        @Test 
    public void iniciaBatalha1SaintComMetadeDaVidaDoOutro ()throws Exception{
        Saint shion = new GoldSaint ("Shion", "Áries");
        Saint mu = new GoldSaint ("Mu", "Touro");
        shion.perderVida(50);
        Batalha b = new Batalha( shion, mu);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (50, mu.getVida(), delta );
        assertEquals (0, shion.getVida(), delta );
    }
}