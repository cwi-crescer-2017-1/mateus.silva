import java.util.ArrayList;
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
    @Test
    public void removerSaintDoArray() throws Exception{
         Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(saga);
         assertEquals(saga, lista.get(0));
         GoldSaint mu = new GoldSaint ("Mu", new Armadura (new Constelacao ("Touro"), Categoria.OURO)); 
         lista.adicionar(mu);
         assertEquals(mu, lista.get(1));
         lista.remover(mu);
         lista.remover(saga);
         ArrayList<Saint>listaSaint = lista.todos();
         assertEquals(true, listaSaint.isEmpty());
    }      
    @Test
    public void buscarPrimeiroSaintComNomeIgualaAoValorDoArgumeto()throws Exception {
         Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         GoldSaint mu = new GoldSaint ("Mu", new Armadura (new Constelacao ("Touro"), Categoria.OURO)); 
         ListaSaint lista = new ListaSaint();
         lista.adicionar(saga);
         lista.adicionar(mu);
         Saint saint = lista.buscarPorNome("Saga");
         assertEquals(true, saint.getNome().equals("Saga"));
    }
    @Test
    public void retornaSubListaDaCategoriaInformadaQueContem3SaintOuro() throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         GoldSaint mu = new GoldSaint("Mu", new Armadura(new Constelacao("Touro"), Categoria.OURO));
         GoldSaint shaka = new GoldSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(saga);
         lista.adicionar(mu);
         lista.adicionar(shaka);
         Categoria categoria = Categoria.OURO;
         ArrayList <Saint> subList =lista.buscarPorCategoria(categoria);
         assertEquals(3, subList.size());
    } 
     @Test
    public void retornaSubListaDaCategoriaInformadaQueContem1SaintBronze() throws Exception{
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(shina);
         Categoria categoria = Categoria.BRONZE;
         ArrayList <Saint> subList =lista.buscarPorCategoria(categoria);
         assertEquals(1, subList.size());
    }  
     @Test
    public void retornaSubListaDaCategoriaInformadaQueContem2SaintPrata() throws Exception{
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         SilverSaint hyoga = new SilverSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.PRATA));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(seiya);
         lista.adicionar(hyoga);
         Categoria categoria = Categoria.PRATA;
         ArrayList <Saint> subList =lista.buscarPorCategoria(categoria);
         assertEquals(2, subList.size());
    }  
    @Test
    public void retornaSubListaDeSaintCom2SaintStatusVivo () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         ListaSaint lista = new ListaSaint();
         lista.adicionar(seiya);
         lista.adicionar(saga);
         saga.perderVida(10);
         seiya.perderVida(90);
         Status status = Status.VIVO;
         ArrayList <Saint> subList =lista.buscarPorStatus(status);
         assertEquals(2, subList.size());
    } 
    @Test
    public void retornaSaintComMaiorVidaSendoQue2SaintTemAMesmaVida () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(seiya);
         lista.adicionar(shina);
         lista.adicionar(saga);
         shina.perderVida(10);
         saga.perderVida(10);
         seiya.perderVida(90);
         assertEquals(shina, lista.getSaintMaiorVida());
    } 
     public void retornaSaintComMaiorVidaNenhumSaintTemAMesmaVida() throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(seiya);
         lista.adicionar(shina);
         lista.adicionar(saga);
         shina.perderVida(6);
         saga.perderVida(1);
         seiya.perderVida(90);
         assertEquals(saga, lista.getSaintMaiorVida());
    }
    @Test
    public void retornaSaintComMenorNenhumTemAMesmaVida () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(shina);
         lista.adicionar(seiya);
         lista.adicionar(saga);
         shina.perderVida(98);
         saga.perderVida(15);
         seiya.perderVida(90);
         assertEquals(shina, lista.getSaintMenorVida());
    } 
     @Test
    public void retornaSaintComMenorVidaSendoQue2TemAMesmaVida () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaint lista = new ListaSaint();
         lista.adicionar(shina);
         lista.adicionar(seiya);
         lista.adicionar(saga);
         shina.perderVida(10);
         seiya.perderVida(100);
         saga.perderVida(110);
         assertEquals(seiya, lista.getSaintMenorVida());
    } 
}