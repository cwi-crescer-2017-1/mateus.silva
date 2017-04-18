

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListaSaintTest{
    @Test
    public void adicionarSaintALista() throws Exception{
         Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(saga);
         assertEquals(saga, lista.get(0));
    }
}
