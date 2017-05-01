import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoQueAtacaEmOrdemAlternadaTest{
     @Test 
   public void ordena3SaintsDeCategoriasDistintasEmOrdemAlternada () throws Exception {
       GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       BronzeSaint shina = new BronzeSaint ("Shina", "Cobra");
       ExercitoQueAtacaEmOrdemAlternada exercito = new ExercitoQueAtacaEmOrdemAlternada ();
       exercito.alistar(shaka);
       exercito.alistar(seiya);
       exercito.alistar(shina);
       ArrayList <Saint> arrayDeSaintsEmOrdemAlternada = new ArrayList ();
       arrayDeSaintsEmOrdemAlternada  = exercito.ordenar();
       assertEquals(shina, arrayDeSaintsEmOrdemAlternada.get(0));
       assertEquals(seiya, arrayDeSaintsEmOrdemAlternada.get(1));
       assertEquals(shaka, arrayDeSaintsEmOrdemAlternada.get(2));
    }
   @Test 
   public void ordena6SaintsDeCategoriasDistintasEmOrdemAlternada () throws Exception {
       GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       BronzeSaint shina = new BronzeSaint ("Shina", "Cobra");
       GoldSaint mu = new GoldSaint ("Mu", "Touro");
       SilverSaint hyoga = new SilverSaint ("Hyoga", "Cisne");
       BronzeSaint iki = new BronzeSaint ("Iki", "Fenix");
       ExercitoQueAtacaEmOrdemAlternada exercito = new ExercitoQueAtacaEmOrdemAlternada ();
       exercito.alistar(shaka);
       exercito.alistar(seiya);
       exercito.alistar(shina);
       exercito.alistar(mu);
       exercito.alistar(hyoga);
       exercito.alistar(iki);
       ArrayList <Saint> arrayDeSaintsEmOrdemAlternada = new ArrayList ();
       arrayDeSaintsEmOrdemAlternada  = exercito.ordenar();
       assertEquals(shina, arrayDeSaintsEmOrdemAlternada.get(0));
       assertEquals(iki, arrayDeSaintsEmOrdemAlternada.get(3));
       assertEquals(seiya, arrayDeSaintsEmOrdemAlternada.get(1));
       assertEquals(hyoga, arrayDeSaintsEmOrdemAlternada.get(4));
       assertEquals(shaka, arrayDeSaintsEmOrdemAlternada.get(2));
       assertEquals(mu, arrayDeSaintsEmOrdemAlternada.get(5));
    }
     @Test 
   public void ordena3SaintsDeCategoriasDoisDeCategoriasIguaisEmOrdemAlternada () throws Exception {
       GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       SilverSaint hyoga = new SilverSaint ("Hyoga", "Cisne");
      ExercitoQueAtacaEmOrdemAlternada exercito = new ExercitoQueAtacaEmOrdemAlternada ();
       exercito.alistar(shaka);
       exercito.alistar(seiya);
       exercito.alistar(hyoga);
       ArrayList <Saint> arrayDeSaintsEmOrdemAlternada  = new ArrayList ();
       arrayDeSaintsEmOrdemAlternada   = exercito.ordenar();
       assertEquals(seiya, arrayDeSaintsEmOrdemAlternada.get(0));
       assertEquals(hyoga, arrayDeSaintsEmOrdemAlternada.get(2));
       assertEquals(shaka, arrayDeSaintsEmOrdemAlternada.get(1));
    }
        @Test 
   public void ordenaExercitoSemSaints () throws Exception {
       ExercitoQueAtacaEmOrdemAlternada exercito = new ExercitoQueAtacaEmOrdemAlternada ();
       ArrayList <Saint> arrayDeSaintsEmOrdemAlternada   = new ArrayList ();
       arrayDeSaintsEmOrdemAlternada  = exercito.ordenar();
       assertEquals (0,arrayDeSaintsEmOrdemAlternada.size());
    }
}