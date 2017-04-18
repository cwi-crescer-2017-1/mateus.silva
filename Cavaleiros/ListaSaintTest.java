

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListaSaintTest{
     @Test
    public void adicionar1SaintALista() throws Exception{
         Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(saga);
         assertEquals(saga, lista.get(0));
    }
    @Test
    public void adicionar2SaintALista() throws Exception{
         Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(saga);
         assertEquals(saga, lista.get(0));
         GoldSaint mu = new GoldSaint ("Mu", new Armadura (new Constelacao ("Touro"), Categoria.OURO)); 
         lista.adicionar(mu);
         assertEquals(mu, lista.get(1));
    }
}