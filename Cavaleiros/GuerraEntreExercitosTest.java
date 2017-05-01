import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class GuerraEntreExercitosTest{
    @Test
   public void GuerraEntreExercitosDe3Saints() throws Exception {
       GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       BronzeSaint shina = new BronzeSaint ("Shina", "Cobra");
       GoldSaint mu = new GoldSaint ("Mu", "Touro");
       SilverSaint hyoga = new SilverSaint ("Hyoga", "Cisne");
       BronzeSaint iki = new BronzeSaint ("Iki", "Fênix");
       Golpe golpe1 = new Golpe ("Cobra", 10); 
       Golpe golpe2 = new Golpe ("Meteoro de Pégasus", 10);
       Golpe golpe3 = new Golpe ("Velocidade da Luz", 10);
       Golpe golpe4 = new Golpe ("Fenix", 10); 
       Golpe golpe5 = new Golpe ("Gelo", 10);
       Golpe golpe6 = new Golpe ("Chifrada", 10);
       shina.aprenderGolpe(golpe1);
       seiya.aprenderGolpe(golpe2);
       shaka.aprenderGolpe(golpe3);
       iki.aprenderGolpe(golpe4);
       hyoga.aprenderGolpe(golpe5);
       mu.aprenderGolpe(golpe6);
       Golpear golpear1 = new Golpear (shina, iki);
       Golpear golpear2 = new Golpear (seiya, hyoga);
       Golpear golpear3 = new Golpear (shaka, mu);
       Golpear golpear4 = new Golpear (iki, shina);
       Golpear golpear5 = new Golpear (hyoga, seiya);
       Golpear golpear6 = new Golpear (mu, shaka);
       shina.adicionarMovimento(golpear1);
       seiya.adicionarMovimento(golpear2);
       shaka.adicionarMovimento(golpear3);
       iki.adicionarMovimento(golpear4);
       hyoga.adicionarMovimento(golpear5);
       mu.adicionarMovimento(golpear6);
       ExercitoQueAtacaEmOrdemAlternada exercitoOrdemAlternada = new ExercitoQueAtacaEmOrdemAlternada ();
       exercitoOrdemAlternada.alistar(shaka);
       exercitoOrdemAlternada.alistar(seiya);
       exercitoOrdemAlternada.alistar(shina);
       ArrayList <Saint> arrayDeSaintsEmOrdemAlternada = new ArrayList ();
       arrayDeSaintsEmOrdemAlternada  = exercitoOrdemAlternada.ordenar();
       ExercitoQueAtacaEmOrdemHierarquica exercitoOrdemHierarquica = new ExercitoQueAtacaEmOrdemHierarquica ();
       exercitoOrdemHierarquica.alistar(mu);
       exercitoOrdemHierarquica.alistar(hyoga);
       exercitoOrdemHierarquica.alistar(iki);
       ArrayList <Saint> arrayDeSaintsEmOrdemHierarquica = new ArrayList ();
       arrayDeSaintsEmOrdemHierarquica =  exercitoOrdemHierarquica.ordenar();
       GuerraEntreExercitos guerra = new GuerraEntreExercitos (arrayDeSaintsEmOrdemHierarquica ,arrayDeSaintsEmOrdemAlternada);
       guerra.comecarGuerra();
       assertEquals(true, guerra.vencedorEhDaOrdemHierarquica());
       assertEquals(false, guerra.vencedorEhDaOrdemAlternada());
    }

    @Test
   public void GuerraEntreExercitosDeSaintsAlternadaTem1Ouro2PrataHierarquicaTem1Prata2Bronze() throws Exception {
       GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       BronzeSaint shina = new BronzeSaint ("Shina", "Cobra");
       SilverSaint shiryu = new SilverSaint ("Shiryu", "Dragão");
       SilverSaint hyoga = new SilverSaint ("Hyoga", "Cisne");
       BronzeSaint iki = new BronzeSaint ("Iki", "Fênix");
       Golpe golpe1 = new Golpe ("Cobra", 10); 
       Golpe golpe2 = new Golpe ("Meteoro de Pégasus", 10);
       Golpe golpe3 = new Golpe ("Velocidade da Luz", 10);
       Golpe golpe4 = new Golpe ("Fenix", 10); 
       Golpe golpe5 = new Golpe ("Gelo", 10);
       Golpe golpe6 = new Golpe ("Cólera do Dragão", 10);
       shina.aprenderGolpe(golpe1);
       seiya.aprenderGolpe(golpe2);
       shaka.aprenderGolpe(golpe3);
       iki.aprenderGolpe(golpe4);
       hyoga.aprenderGolpe(golpe5);
       shiryu.aprenderGolpe(golpe6);
       Golpear golpear1 = new Golpear (seiya, iki);
       Golpear golpear2 = new Golpear (shaka, shina);
       Golpear golpear3 = new Golpear (shiryu, hyoga);
       Golpear golpear4 = new Golpear (iki, seiya);
       Golpear golpear5 = new Golpear (shina, shaka);
       Golpear golpear6 = new Golpear (hyoga, shiryu);
       seiya.adicionarMovimento(golpear1);
       shaka.adicionarMovimento(golpear2);
       shiryu.adicionarMovimento(golpear3);
       iki.adicionarMovimento(golpear4);
       shina.adicionarMovimento(golpear5);
       hyoga.adicionarMovimento(golpear6);
       VestirArmadura seiyaVestirArmadura = new VestirArmadura (seiya);
       VestirArmadura shakaVestirArmadura = new VestirArmadura (shaka); 
       VestirArmadura shinaVestirArmadura = new VestirArmadura (shina);
       VestirArmadura ikiVestirArmadura = new VestirArmadura (iki); 
       VestirArmadura shiryuVestirArmadura = new VestirArmadura (shiryu);
       VestirArmadura hyogaVestirArmadura = new VestirArmadura (hyoga); 
       seiya.adicionarMovimento(seiyaVestirArmadura);
       shaka.adicionarMovimento(shakaVestirArmadura);
       shiryu.adicionarMovimento(shiryuVestirArmadura);
       hyoga.adicionarMovimento(hyogaVestirArmadura);
       iki.adicionarMovimento(ikiVestirArmadura);
       shina.adicionarMovimento(shinaVestirArmadura);
       ExercitoQueAtacaEmOrdemAlternada exercitoOrdemAlternada = new ExercitoQueAtacaEmOrdemAlternada ();
       exercitoOrdemAlternada.alistar(shaka);
       exercitoOrdemAlternada.alistar(seiya);
       exercitoOrdemAlternada.alistar(shiryu);
       ArrayList <Saint> arrayDeSaintsEmOrdemAlternada = new ArrayList ();
       arrayDeSaintsEmOrdemAlternada  = exercitoOrdemAlternada.ordenar();
       ExercitoQueAtacaEmOrdemHierarquica exercitoOrdemHierarquica = new ExercitoQueAtacaEmOrdemHierarquica ();
       exercitoOrdemHierarquica.alistar(iki);
       exercitoOrdemHierarquica.alistar(hyoga);
       exercitoOrdemHierarquica.alistar(shina);
       ArrayList <Saint> arrayDeSaintsEmOrdemHierarquica = new ArrayList ();
       arrayDeSaintsEmOrdemHierarquica =  exercitoOrdemHierarquica.ordenar();
       GuerraEntreExercitos guerra = new GuerraEntreExercitos (arrayDeSaintsEmOrdemHierarquica ,arrayDeSaintsEmOrdemAlternada);
       guerra.comecarGuerra();
       assertEquals(false, guerra.vencedorEhDaOrdemHierarquica());
       assertEquals(true, guerra.vencedorEhDaOrdemAlternada());
    }
}