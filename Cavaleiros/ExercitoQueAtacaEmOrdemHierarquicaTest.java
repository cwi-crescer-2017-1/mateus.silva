

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoQueAtacaEmOrdemHierarquicaTest{
   @Test 
   public void ordena3SaintsDeCategoriasDistintasEmOrdemHierarquica () throws Exception {
       GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       BronzeSaint shina = new BronzeSaint ("Shina", "Cobra");
       ExercitoQueAtacaEmOrdemHierarquica exercito = new ExercitoQueAtacaEmOrdemHierarquica ();
       exercito.alistar(shaka);
       exercito.alistar(seiya);
       exercito.alistar(shina);
       ArrayList <Saint> arrayDeSaintsEmOrdemHierarquica = new ArrayList ();
       arrayDeSaintsEmOrdemHierarquica = exercito.ordenar();
       assertEquals(shina, arrayDeSaintsEmOrdemHierarquica.get(0));
       assertEquals(seiya, arrayDeSaintsEmOrdemHierarquica.get(1));
       assertEquals(shaka, arrayDeSaintsEmOrdemHierarquica.get(2));
    }
   @Test 
   public void ordena6SaintsDeCategoriasDistintasEmOrdemHierarquica () throws Exception {
       GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       BronzeSaint shina = new BronzeSaint ("Shina", "Cobra");
       GoldSaint mu = new GoldSaint ("Mu", "Touro");
       SilverSaint hyoga = new SilverSaint ("Hyoga", "Cisne");
       BronzeSaint iki = new BronzeSaint ("Iki", "Fenix");
       ExercitoQueAtacaEmOrdemHierarquica exercito = new ExercitoQueAtacaEmOrdemHierarquica ();
       exercito.alistar(shaka);
       exercito.alistar(seiya);
       exercito.alistar(shina);
       exercito.alistar(mu);
       exercito.alistar(hyoga);
       exercito.alistar(iki);
       ArrayList <Saint> arrayDeSaintsEmOrdemHierarquica = new ArrayList ();
       arrayDeSaintsEmOrdemHierarquica = exercito.ordenar();
       assertEquals(shina, arrayDeSaintsEmOrdemHierarquica.get(0));
       assertEquals(iki, arrayDeSaintsEmOrdemHierarquica.get(1));
       assertEquals(seiya, arrayDeSaintsEmOrdemHierarquica.get(2));
       assertEquals(hyoga, arrayDeSaintsEmOrdemHierarquica.get(3));
       assertEquals(shaka, arrayDeSaintsEmOrdemHierarquica.get(4));
       assertEquals(mu, arrayDeSaintsEmOrdemHierarquica.get(5));
    }
     @Test 
   public void ordena3SaintsDeCategoriasDoisDeCategoriasIguaisEmOrdemHierarquica () throws Exception {
       GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       SilverSaint hyoga = new SilverSaint ("Hyoga", "Cisne");
       ExercitoQueAtacaEmOrdemHierarquica exercito = new ExercitoQueAtacaEmOrdemHierarquica ();
       exercito.alistar(shaka);
       exercito.alistar(seiya);
       exercito.alistar(hyoga);
       ArrayList <Saint> arrayDeSaintsEmOrdemHierarquica  = new ArrayList ();
       arrayDeSaintsEmOrdemHierarquica  = exercito.ordenar();
       assertEquals(seiya, arrayDeSaintsEmOrdemHierarquica.get(0));
       assertEquals(hyoga, arrayDeSaintsEmOrdemHierarquica.get(1));
       assertEquals(shaka, arrayDeSaintsEmOrdemHierarquica.get(2));
    }
        @Test 
   public void ordenaExercitoSemSaints () throws Exception {
       ExercitoQueAtacaEmOrdemHierarquica exercito = new ExercitoQueAtacaEmOrdemHierarquica ();
       ArrayList <Saint> arrayDeSaintsEmOrdemHierarquica  = new ArrayList ();
       arrayDeSaintsEmOrdemHierarquica  = exercito.ordenar();
       assertEquals (0,arrayDeSaintsEmOrdemHierarquica.size());
    }
}
