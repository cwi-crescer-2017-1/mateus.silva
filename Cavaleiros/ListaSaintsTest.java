import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSaintsTest{
     @Test
    public void adicionar1SaintALista() throws Exception{
         Saint saga = new GoldSaint("Saga","Gêmeos");
         ListaSaints  lista = new  ListaSaints();
         lista.adicionar(saga);
         assertEquals(saga, lista.get(0));
    }
    @Test
    public void adicionar2SaintALista() throws Exception{
         Saint saga = new GoldSaint("Saga", "Gêmeos");
         ListaSaints lista = new ListaSaints();
         lista.adicionar(saga);
         assertEquals(saga, lista.get(0));
         GoldSaint mu = new GoldSaint ("Mu", "Touro"); 
         lista.adicionar(mu);
         assertEquals(mu, lista.get(1));
    }
    @Test
    public void removerSaintDoArray() throws Exception{
         Saint saga = new GoldSaint("Saga", "Gêmeos");
         ListaSaints lista = new ListaSaints();
         lista.adicionar(saga);
         assertEquals(saga, lista.get(0));
         GoldSaint mu = new GoldSaint ("Mu", "Touro"); 
         lista.adicionar(mu);
         assertEquals(mu, lista.get(1));
         lista.remover(mu);
         lista.remover(saga);
         ArrayList<Saint>listaSaint = lista.todos();
         assertEquals(true, listaSaint.isEmpty());
    }      
    @Test
    public void buscarPrimeiroSaintComNomeIgualaAoValorDoArgumeto()throws Exception {
         Saint saga = new GoldSaint("Saga", "Gêmeos");
         GoldSaint mu = new GoldSaint ("Mu","Touro"); 
         ListaSaints lista = new ListaSaints();
         lista.adicionar(saga);
         lista.adicionar(mu);
         Saint saint = lista.buscarPorNome("Saga");
         assertEquals(true, saint.getNome().equals("Saga"));
    }
    @Test
    public void retornaSubListaDaCategoriaInformadaQueContem3SaintOuro() throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         GoldSaint mu = new GoldSaint("Mu", "Touro");
         GoldSaint shaka = new GoldSaint("Shaka", "Virgem");
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
         BronzeSaint shina = new BronzeSaint("Shina", "Cobra");
         ListaSaints lista = new ListaSaints();
         lista.adicionar(shina);
         Categoria categoria = Categoria.BRONZE;
         ArrayList <Saint> subLista =lista.buscarPorCategoria(categoria);
         assertEquals(1, subLista.size());
    }  
     @Test
    public void retornaSubListaDaCategoriaInformadaQueContem2SaintPrata() throws Exception{
         SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
         SilverSaint hyoga = new SilverSaint("Hyoga", "Cisne");
         ListaSaints lista = new ListaSaints();
         lista.adicionar(seiya);
         lista.adicionar(hyoga);
         Categoria categoria = Categoria.PRATA;
         ArrayList <Saint> subLista =lista.buscarPorCategoria(categoria);
         assertEquals(2, subLista.size());
    }  
    @Test
    public void retornaSubListaDeSaintCom2SaintStatusVivo () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
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
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
         BronzeSaint shina = new BronzeSaint("Shina", "Cobra");
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
    public void retornaSaintComMaiorVidaListaVazia () throws Exception{
         ListaSaints lista = new ListaSaints();
         assertNull(lista.getSaintMaiorVida());
    }
     public void retornaSaintComMaiorVidaNenhumSaintTemAMesmaVida() throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
         BronzeSaint shina = new BronzeSaint("Shina", "Cobra");
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
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
         BronzeSaint shina = new BronzeSaint("Shina", "Cobra");
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
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
         BronzeSaint shina = new BronzeSaint("Shina", "Cobra");
         ListaSaints lista = new ListaSaints();
         lista.adicionar(shina);
         lista.adicionar(seiya);
         lista.adicionar(saga);
         shina.perderVida(10);
         seiya.perderVida(100);
         saga.perderVida(110);
         assertEquals(seiya, lista.getSaintMenorVida());
    }@Test
    public void retornaSaintComMenorVidaListaVazia () throws Exception{
         ListaSaints lista = new ListaSaints();
         assertNull(lista.getSaintMenorVida());
    }
    @Test
    public void ordenaAListaEmOrdemCrescenteSendoQueAOrdemEstaDecrescente () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
         BronzeSaint shina = new BronzeSaint("Shina", "Cobra");
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
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
         BronzeSaint shina = new BronzeSaint("Shina", "Cobra");
         BronzeSaint shina1 = new BronzeSaint("Shina", "Cobra");
         BronzeSaint shina2 = new BronzeSaint("Shina", "Cobra");
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
      @Test
    public void ordenaAListaEmOrdemAscedente () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
         BronzeSaint shina = new BronzeSaint("Shina", "Cobra");
         BronzeSaint shina1 = new BronzeSaint("Shina", "Cobra");
         BronzeSaint shina2 = new BronzeSaint("Shina", "Cobra");
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
         lista.ordenar(TipoOrdenacao.ASCENDENTE);
         assertEquals(seiya,lista.get(0));
         assertEquals(saga,lista.get(2));
         assertEquals(shina,lista.get(1));
         assertEquals(shina1,lista.get(3));
         assertEquals(shina2,lista.get(4));
    }
      @Test
    public void ordenaAListaEmOrdemDescedente () throws Exception{
         GoldSaint saga = new GoldSaint("Saga","Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
         BronzeSaint shina = new BronzeSaint("Shina", "Cobra");
         BronzeSaint shina1 = new BronzeSaint("Shina", "Cobra");
         BronzeSaint shina2 = new BronzeSaint("Shina", "Cobra");
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
         lista.ordenar(TipoOrdenacao.DESCENDENTE);
         assertEquals(seiya,lista.get(4));
         assertEquals(saga,lista.get(2));
         assertEquals(shina,lista.get(3));
         assertEquals(shina1,lista.get(1));
         assertEquals(shina2,lista.get(0));
    }
    @Test
    public void ordenaAListaEmOrdemDescedenteComListaVazia () throws Exception{
         ListaSaints lista = new ListaSaints();
         lista.ordenar(TipoOrdenacao.DESCENDENTE);
         ArrayList<Saint>listaSaint = lista.todos();
         assertEquals(0,listaSaint.size());
    }
    @Test
    public void ordenaAListaEmOrdemAscedenteComListaVazia () throws Exception{
         ListaSaints lista = new ListaSaints();
         lista.ordenar(TipoOrdenacao.DESCENDENTE);
         ArrayList<Saint>listaSaint = lista.todos();
         assertEquals(0,listaSaint.size());
    }
    @Test
    public void unirDoisArraysNaoVazios () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
         ListaSaints lista1 = new ListaSaints();
         lista1.adicionar(seiya);
         ListaSaints lista2 = new ListaSaints();
         lista2.adicionar(saga);
         ArrayList <Saint> listaSaint = lista2.todos();
         ArrayList <Saint> listaSaint2 =lista1.unir(listaSaint);
         assertEquals(2, listaSaint2.size());
    }
    @Test
    public void unirDoisArraysVazios () throws Exception{
         ListaSaints lista1 = new ListaSaints();
         ListaSaints lista2 = new ListaSaints();
         ArrayList <Saint> listaSaint = lista2.todos();
         ArrayList <Saint> listaSaint2 =lista1.unir(listaSaint);
         assertEquals(0, listaSaint2.size());
    }
    @Test
    public void unirDoisArraysDeSize5e3 () throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
         ListaSaints lista1 = new ListaSaints();
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         ListaSaints lista2 = new ListaSaints();
         lista2.adicionar(saga);
         lista2.adicionar(saga);
         lista2.adicionar(saga);
         ArrayList <Saint> listaSaint = lista2.todos();
         ArrayList <Saint> listaSaint2 =lista1.unir(listaSaint);
         assertEquals(8, listaSaint2.size());
    }
    @Test
    public void diffNenhumObjetoEmComum() throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
         BronzeSaint shina = new BronzeSaint ("Shina", "Cobra");
         GoldSaint mu = new GoldSaint ("Mu", "Touro");
         GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
         SilverSaint hyoga = new SilverSaint ("Hyoga","Cisne"); 
         ListaSaints lista1 = new ListaSaints();
         lista1.adicionar(seiya);
         lista1.adicionar(saga);
         lista1.adicionar(shina);
         ListaSaints lista2 = new ListaSaints();
         lista2.adicionar(mu);
         lista2.adicionar(hyoga);
         lista2.adicionar(shaka);
         ListaSaints resultado = lista1.diff(lista2);
         ArrayList <Saint> resultado1 = resultado.todos();
         assertEquals (3, resultado1.size());
    }
    @Test
    public void diff2ObjeoEmComum()throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
         BronzeSaint shina = new BronzeSaint ("Shina", "Cobra");
         GoldSaint mu = new GoldSaint ("Mu", "Touro");
         GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
         SilverSaint hyoga = new SilverSaint ("Hyoga","Cisne"); 
         ListaSaints lista1 = new ListaSaints();
         lista1.adicionar(seiya);
         lista1.adicionar(hyoga);
         lista1.adicionar(saga);
         ListaSaints lista2 = new ListaSaints();
         lista2.adicionar(mu);
         lista2.adicionar(seiya);
         lista2.adicionar(saga);
         ListaSaints resultado = lista1.diff(lista2);
          ArrayList <Saint> resultado1 = resultado.todos();
         assertEquals(1, resultado1.size());
    }
     @Test
    public void diffDe2ObjetosEmComum()throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
         BronzeSaint shina = new BronzeSaint ("Shina", "Cobra");
         GoldSaint mu = new GoldSaint ("Mu", "Touro");
         GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
         SilverSaint hyoga = new SilverSaint ("Hyoga","Cisne"); 
         ListaSaints lista1 = new ListaSaints();
         lista1.adicionar(seiya);
         lista1.adicionar(saga);
         lista1.adicionar(hyoga);
         lista1.adicionar(mu);
         lista1.adicionar(shaka);
         ListaSaints lista2 = new ListaSaints();
         lista2.adicionar(seiya);
         lista2.adicionar(saga);
         lista2.adicionar(shaka);
         lista2.adicionar(shina);
         ListaSaints resultado = lista1.diff(lista2);
         ArrayList <Saint> resultado1 = resultado.todos();
         assertEquals(2, resultado1.size());
    }
    @Test
    public void intersecDoisArraysDe3ObjetosE1ObjetoEmComum() throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
         ListaSaints lista1 = new ListaSaints();
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         ListaSaints lista2 = new ListaSaints();
         lista2.adicionar(saga);
         lista2.adicionar(seiya);
         lista2.adicionar(saga);
         ArrayList <Saint> listaSaint = lista2.todos();
         ArrayList <Saint> listaSaint2 =lista1.intersec(listaSaint);
         assertEquals(1, listaSaint2.size());
    }
    @Test
    public void intersecDoisArraysDe3ObjetosE3ObjetosEmComum()throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
         ListaSaints lista1 = new ListaSaints();
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         ListaSaints lista2 = new ListaSaints();
         lista2.adicionar(seiya);
         lista2.adicionar(seiya);
         lista2.adicionar(seiya);
         ArrayList <Saint> listaSaint = lista2.todos();
         ArrayList <Saint> listaSaint2 =lista1.intersec(listaSaint);
         assertEquals(3, listaSaint2.size());
    }
     @Test
    public void intersecDoisArraysDe5ObjetosE2ObjetosEmComum()throws Exception{
         GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
         SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
         ListaSaints lista1 = new ListaSaints();
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         lista1.adicionar(seiya);
         ListaSaints lista2 = new ListaSaints();
         lista2.adicionar(seiya);
         lista2.adicionar(seiya);
         seiya = new SilverSaint ("Seiya", "Touro");
         lista2.adicionar(seiya);
         lista2.adicionar(saga);
         lista2.adicionar(saga);
         ArrayList <Saint> listaSaint = lista2.todos();
         ArrayList <Saint> listaSaint2 =lista1.intersec(listaSaint);
         assertEquals(2, listaSaint2.size());
    }
     @Test
    public void getCSVComListaVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        assertEquals("", lista.getCSV());
    }
    @Test
    public void getCSVComApenasUmSaint() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, lista.getCSV());
    }
    @Test
    public void getCSVComApenasDoisSaints() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        Saint dohko = new GoldSaint("Dohko", "Touro");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionar(dohko);
        String separador = System.getProperty("line.separator");
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false"+separador+"Dohko,10.0,Touro,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, lista.getCSV());
    }
}