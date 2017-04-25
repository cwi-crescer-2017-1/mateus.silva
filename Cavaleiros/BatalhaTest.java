import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class BatalhaTest{
     @Test 
    public void iniciaBatalhaGoldSaintGoldPrata()throws Exception{
        Saint seiya = new SilverSaint ("Seiya", "Pégaso");
        Saint shion = new GoldSaint ("Shion", "Áries");
        Golpe golpe1 = new Golpe ("Meteoro de Pégasus", 10);
        Golpe golpe2 = new Golpe ("Cometa de Pégasus", 5);
        Golpe golpe3 = new Golpe ("Chute de Pégasus", 2);
        Golpe golpe4 = new Golpe ("Muralha de Cristal", 10);
        Golpe golpe5 = new Golpe ( "Extinção Estelar", 7);
        Golpe golpe6 = new Golpe ("Rede de Cristal", 8); 
        seiya.aprenderGolpe(golpe1);
        seiya.aprenderGolpe(golpe2);
        seiya.aprenderGolpe(golpe3);
        shion.aprenderGolpe(golpe4);
        shion.aprenderGolpe(golpe5);
        shion.aprenderGolpe(golpe6);
        Golpear golpear1 = new Golpear (seiya, shion);
        Golpear golpear2 = new Golpear (shion, seiya);
        VestirArmadura seiyaVestirArmadura = new VestirArmadura (seiya);
        VestirArmadura shionVestirArmadura = new VestirArmadura (shion);   
        seiya.adicionarMovimento(golpear1);
        seiya.adicionarMovimento(seiyaVestirArmadura);
        shion.adicionarMovimento(golpear2);
        shion.adicionarMovimento(shionVestirArmadura);
        Batalha b = new Batalha(seiya, shion);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (0, seiya.getVida(), delta );
        assertEquals (39, shion.getVida(), delta );
    }
     @Test 
    public void iniciaBatalhaGoldSaintBronzeSaint()throws Exception{
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint shion = new GoldSaint ("Shion", "Áries");
        Golpe golpe1 = new Golpe ("Meteoro de Pégasus", 10);
        Golpe golpe2 = new Golpe ("Rede de Cristal", 8); 
        seiya.aprenderGolpe(golpe1);
        shion.aprenderGolpe(golpe2);
        Golpear golpear1 = new Golpear (seiya, shion);
        Golpear golpear2 = new Golpear (shion, seiya);
        VestirArmadura seiyaVestirArmadura = new VestirArmadura (seiya);
        VestirArmadura shionVestirArmadura = new VestirArmadura (shion);
        seiya.adicionarMovimento(golpear1);
        seiya.adicionarMovimento(seiyaVestirArmadura);
        shion.adicionarMovimento(golpear2);
        shion.adicionarMovimento(shionVestirArmadura);
        Batalha b = new Batalha(seiya, shion);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (0, seiya.getVida(), delta );
        assertEquals (30, shion.getVida(), delta );
    }
     @Test 
    public void iniciaBatalhaComDoisCavaleirosDaMesmaCategoria()throws Exception{
        Saint mu = new GoldSaint ("Mu", "Touro");
        Saint shion = new GoldSaint ("Shion", "Áries");
        Golpe golpe1 = new Golpe ("Rede de Cristal", 15);
        Golpe golpe2 = new Golpe ("Chifrada", 20); 
        shion.aprenderGolpe(golpe1);
        mu.aprenderGolpe(golpe2);
        Golpear golpear1 = new Golpear (shion, mu);
        Golpear golpear2 = new Golpear (mu, shion);
        VestirArmadura shionVestirArmadura = new VestirArmadura (mu);
        VestirArmadura muVestirArmadura = new VestirArmadura (shion);
        shion.adicionarMovimento(golpear1);
        shion.adicionarMovimento(shionVestirArmadura);
        mu.adicionarMovimento(golpear2);
        mu.adicionarMovimento(muVestirArmadura);
        Batalha b = new Batalha(mu, shion);
        double delta  = 0.0000001;
        b.iniciar();
        assertEquals (25, mu.getVida(), delta );
        assertEquals (0, shion.getVida(), delta );
    }
        @Test 
    public void iniciaBatalhaSilverBronze ()throws Exception{
       Saint seiya = new SilverSaint ("Seiya", "Pégaso");
       Saint shina = new BronzeSaint ("Shina", "Cobra");
       Golpe golpe1 = new Golpe ("Meteoro de Pégasus", 10);
       Golpe golpe2 = new Golpe ("Cobra", 8); 
       seiya.aprenderGolpe(golpe1);
       shina.aprenderGolpe(golpe2);
       Golpear golpear1 = new Golpear (seiya, shina);
       Golpear golpear2 = new Golpear (shina, seiya);
       VestirArmadura seiyaVestirArmadura = new VestirArmadura (seiya);
       VestirArmadura shinaVestirArmadura = new VestirArmadura (shina);
       seiya.adicionarMovimento(golpear1);
       seiya.adicionarMovimento(seiyaVestirArmadura);
       shina.adicionarMovimento(golpear2);
       shina.adicionarMovimento(shinaVestirArmadura);
       Batalha b = new Batalha(seiya, shina);
       double delta  = 0.0000001;
       b.iniciar();
       assertEquals (44, seiya.getVida(), delta );
       assertEquals (0, shina.getVida(), delta );
    }
        @Test 
    public void iniciaBatalha1SaintSemVida ()throws Exception{
       Saint seiya = new SilverSaint ("Seiya", "Pégaso");
       Saint shina = new BronzeSaint ("Shina", "Cobra");
       Golpe golpe1 = new Golpe ("Meteoro de Pégasus", 10);
       Golpe golpe2 = new Golpe ("Cobra", 8); 
       seiya.aprenderGolpe(golpe1);
       shina.aprenderGolpe(golpe2);
       Golpear golpear1 = new Golpear (seiya, shina);
       Golpear golpear2 = new Golpear (shina, seiya);
       VestirArmadura seiyaVestirArmadura = new VestirArmadura (seiya);
       VestirArmadura shinaVestirArmadura = new VestirArmadura (shina);
       seiya.adicionarMovimento(golpear1);
       seiya.adicionarMovimento(seiyaVestirArmadura);
       shina.adicionarMovimento(golpear2);
       shina.adicionarMovimento(shinaVestirArmadura);
       Batalha b = new Batalha(seiya, shina);
       double delta  = 0.0000001;
       seiya.perderVida(100);
       b.iniciar();
       assertEquals (0, seiya.getVida(), delta );
       assertEquals (100, shina.getVida(), delta );
    }
        @Test 
    public void iniciaBatalhaSaint1ComeçaVestindoArmadura ()throws Exception{
       Saint seiya = new SilverSaint ("Seiya", "Pégaso");
       Saint shina = new BronzeSaint ("Shina", "Cobra");
       Golpe golpe1 = new Golpe ("Meteoro de Pégasus", 10);
       Golpe golpe2 = new Golpe ("Cobra", 8); 
       seiya.aprenderGolpe(golpe1);
       shina.aprenderGolpe(golpe2);
       Golpear golpear1 = new Golpear (seiya, shina);
       Golpear golpear2 = new Golpear (shina, seiya);
       VestirArmadura seiyaVestirArmadura = new VestirArmadura (seiya);
       VestirArmadura shinaVestirArmadura = new VestirArmadura (shina);
       seiya.adicionarMovimento(seiyaVestirArmadura);
       seiya.adicionarMovimento(golpear1);
       shina.adicionarMovimento(golpear2);
       shina.adicionarMovimento(shinaVestirArmadura);
       Batalha b = new Batalha(seiya, shina);
       double delta  = 0.0000001;
       b.iniciar();
       assertEquals (60, seiya.getVida(), delta );
       assertEquals (0, shina.getVida(), delta );
    }
      @Test 
    public void saintsSemMovimento ()throws Exception{
       Saint seiya = new SilverSaint ("Seiya", "Pégaso");
       Saint shina = new BronzeSaint ("Shina", "Cobra");
       Batalha b = new Batalha(seiya, shina);
       b.iniciar();
       assertEquals (90, shina.getVida(),0.001 );
     }
    @Test 
    public void SaintComMovimentosSemDano ()throws Exception{
       Saint seiya = new SilverSaint ("Seiya", "Pégaso");
       Saint shina = new BronzeSaint ("Shina", "Cobra");
       VestirArmadura seiyaVestirArmadura = new VestirArmadura (seiya);
       VestirArmadura shinaVestirArmadura = new VestirArmadura (shina);
       seiya.adicionarMovimento(seiyaVestirArmadura);
       shina.adicionarMovimento(shinaVestirArmadura);
       Batalha b = new Batalha(seiya, shina);
       double delta  = 0.0000001;
       b.iniciar();
       assertEquals (90, shina.getVida(), delta );
    }
}