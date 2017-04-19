import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSaintsTest{
     @Test
    public void adicionar1SaintALista() throws Exception{
         Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         ListaSaints lista = new ListaSaints();
         lista.adicionar(saga);
         assertEquals(saga, lista.get(0));
    }
    @Test
    public void adicionar2SaintALista() throws Exception{
         Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         ListaSaints lista = new ListaSaints();
         lista.adicionar(saga);
         assertEquals(saga, lista.get(0));
         GoldSaint mu = new GoldSaint ("Mu", new Armadura (new Constelacao ("Touro"), Categoria.OURO)); 
         lista.adicionar(mu);
         assertEquals(mu, lista.get(1));
    }
    @Test
    public void removerSaintDoArray() throws Exception{
         Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         ListaSaints lista = new ListaSaints();
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
         ListaSaints lista = new ListaSaints();
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
         ListaSaints lista = new ListaSaints();
         lista.adicionar(saga);
         lista.adicionar(mu);
         lista.adicionar(shaka);
         Categoria categoria = Categoria.OURO;
         ArrayList <Saint> subLista =lista.buscarPorCategoria(categoria);
         assertEquals(3, subLista.size());
    } 
     @Test
    public void retornaSubListaDaCategoriaInformadaQueContem1SaintBronze() throws Exception{
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaints lista = new ListaSaints();
         lista.adicionar(shina);
         Categoria categoria = Categoria.BRONZE;
         ArrayList <Saint> subLista =lista.buscarPorCategoria(categoria);
         assertEquals(1, subLista.size());
    }  
     @Test
    public void retornaSubListaDaCategoriaInformadaQueContem2SaintPrata() throws Exception{
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         SilverSaint hyoga = new SilverSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.PRATA));
         ListaSaints lista = new ListaSaints();
         lista.adicionar(seiya);
         lista.adicionar(hyoga);
         Categoria categoria = Categoria.PRATA;
         ArrayList <Saint> subLista =lista.buscarPorCategoria(categoria);
         assertEquals(2, subLista.size());
    }  
    @Test
    public void retornaSubListaDeSaintCom2SaintStatusVivo () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         ListaSaints lista = new ListaSaints();
         lista.adicionar(seiya);
         lista.adicionar(saga);
         saga.perderVida(10);
         seiya.perderVida(90);
         Status status = Status.VIVO;
         ArrayList <Saint> subLista =lista.buscarPorStatus(status);
         assertEquals(2, subLista.size());
    } 
    @Test
    public void retornaSaintComMaiorVidaSendoQue2SaintTemAMesmaVida () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaints lista = new ListaSaints();
         lista.adicionar(seiya);
         lista.adicionar(shina);
         lista.adicionar(saga);
         shina.perderVida(10);
         saga.perderVida(10);
         seiya.perderVida(90);
         assertEquals(shina, lista.getSaintMaiorVida());
    } 
      @Test
    public void retornaSaintComMaiorListaVazia () throws Exception{
         ListaSaints lista = new ListaSaints();
         assertNull(lista.getSaintMaiorVida());
    }
     public void retornaSaintComMaiorVidaNenhumSaintTemAMesmaVida() throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaints lista = new ListaSaints();
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
         ListaSaints lista = new ListaSaints();
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
         ListaSaints lista = new ListaSaints();
         lista.adicionar(shina);
         lista.adicionar(seiya);
         lista.adicionar(saga);
         shina.perderVida(10);
         seiya.perderVida(100);
         saga.perderVida(110);
         assertEquals(seiya, lista.getSaintMenorVida());
    }
    @Test
    public void ordenaAListaEmOrdemCrescenteSendoQueAOrdemEstaDecrescente () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaints lista = new ListaSaints();
         lista.adicionar(seiya);
         lista.adicionar(shina);
         lista.adicionar(saga);
         seiya.perderVida(10);
         saga.perderVida(50);
         shina.perderVida(90);
         lista.ordenar();
         assertEquals(seiya,lista.get(2));
         assertEquals(saga,lista.get(1));
         assertEquals(shina,lista.get(0));
         assertEquals(10,shina.getVida(),00.1);
         assertEquals(50,saga.getVida(),00.1);
         assertEquals(90,seiya.getVida(),00.1);
    }
      @Test
    public void ordenaAListaEmOrdemCrescenteSendoQueAOrdemAleatória () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
         SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
         BronzeSaint shina = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         BronzeSaint shina1 = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         BronzeSaint shina2 = new BronzeSaint("Shina", new Armadura(new Constelacao("Cobra"), Categoria.BRONZE));
         ListaSaints lista = new ListaSaints();
         lista.adicionar(seiya);
         lista.adicionar(saga);
         lista.adicionar(shina);
         lista.adicionar(shina1);
         lista.adicionar(shina2);
         seiya.perderVida(80);
         saga.perderVida(50);
         shina.perderVida(70);
         shina1.perderVida(40);
         shina2.perderVida(10);
         lista.ordenar();
         assertEquals(seiya,lista.get(0));
         assertEquals(saga,lista.get(2));
         assertEquals(shina,lista.get(1));
         assertEquals(shina1,lista.get(3));
         assertEquals(shina2,lista.get(4));
    }
}