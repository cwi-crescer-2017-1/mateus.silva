import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception{
        Armadura fenix = new Armadura (new Constelacao ("Fenix"), Categoria.BRONZE);
        Saint ikki  = new BronzeSaint ("Ikki", "Fenix");
        ikki.vestirArmadura();
        boolean resultado = ikki.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    @Test
    public void naoVestirArmarduraDeixaArmaduraNaoVestida()throws Exception{
        GoldSaint ionia = new GoldSaint ("Ionia", "Capricórnio");
        assertEquals (false, ionia.getArmaduraVestida());
    }
    @Test
    public void aoCriarSaintGeneroENaoInformado()throws Exception{
        Armadura cobra = new Armadura (new Constelacao ("Cobra"), Categoria.PRATA);
        Saint shina = new SilverSaint ("Shina", "Cobra");
        assertEquals(Genero.NAO_INFORMADO, shina.getGenero());
    }
    @Test 
    public void aoCriarSaintStatusDeveSerVivo()throws Exception{
        GoldSaint shaka = new GoldSaint ("Shaka", "Virgem");
        assertEquals(Status.VIVO, shaka.getStatus());
    }
    @Test
    public void aoCriarSaintVidaDeveSer100()throws Exception{
        GoldSaint shaka = new GoldSaint ("Shaka","Virgem");
        assertEquals(100.0, shaka.getVida(),0.01);
    }
    @Test 
    public void retornaOValorIntDaCategoria ()throws Exception{
        Saint shion = new GoldSaint ("Shion", "Áries");
        int valor = shion.getValorDaCategoria();
        assertEquals (3, valor);
    }
     @Test 
    public void perde10deVidaAoSofrerGolpe ()throws Exception{
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        double delta  = 0.0000001;
        seiya.perderVida(10);
        assertEquals (90, seiya.getVida(), delta);
    }
     @Test 
    public void perde100deVidaAoSofrerGolpe ()throws Exception{
        Saint seiya = new BronzeSaint ("Seiya","Pégaso");
        double delta  = 0.0000001;
        seiya.perderVida(100);
        assertEquals (0, seiya.getVida(), delta);
    }
    @Test 
    public void deveRetonarONomeDoSaint ()throws Exception{
        Saint seiya = new BronzeSaint ("Seiya","Pégaso");  
        String nome = seiya.getNome();
        int nomeInt = nome.compareTo("Seiya");
        assertEquals(0, nomeInt);
    }
    @Test 
    public void deveRetornaVidaDoSaint ()throws Exception{
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");  
        double delta  = 0.0000001;
        assertEquals(100,seiya.getVida(), delta);
    }
    @Test 
    public void deveMudarOGeneroDoSaint ()throws Exception{
        Saint seiya = new BronzeSaint ("Seiya","Pégaso");   
        Genero genero = Genero.MASCULINO;
        seiya.setGenero(genero);
        assertEquals (Genero.MASCULINO,seiya.getGenero());
    }
    @Test 
    public void retornaOGeneroDoSaint ()throws Exception{
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");   
        assertEquals (Genero.NAO_INFORMADO,seiya.getGenero());
    }
    @Test
    public void acriarSaintNasceCom5SentidosDespertados()throws Exception{
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso"); 
        assertEquals(5,seiya.getQtsSentidosDespertados());
    }
    @Test
    public void acriarSaintNasceCom6SentidosDespertados()throws Exception{
        SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso"); 
        assertEquals(6,seiya.getQtsSentidosDespertados());
    }
    @Test
    public void acriarSaintNasceCom7SentidosDespertados()throws Exception{
        GoldSaint mu = new GoldSaint ("Mu", "Touro"); 
        assertEquals(7,mu.getQtsSentidosDespertados());
    }
    @Test
    public void mudaStatusParaMortoQuandoAVidaForMenorQue1 ()throws Exception{
        SilverSaint seiya = new SilverSaint ("Seiya","Pégaso"); 
        seiya.perderVida(110);
        assertEquals(Status.MORTO,seiya.getStatus());
    }
    @Test
    public void  evitarQueSaintTenhaSuaVidaEStatusAlteradoQuandoEstiverMorto () throws Exception{
        SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
         seiya.perderVida(100);
        assertEquals(Status.MORTO,seiya.getStatus());
        seiya.perderVida(10);
        assertEquals(0, seiya.getVida(),0.001);
        assertEquals(Status.MORTO,seiya.getStatus());
    }
    @Test

    public void aprenderUmGolpe() throws Exception {
       Saint saga = new GoldSaint("Saga", "Gêmeos");
       Golpe outraDimensao = new Golpe("Outra dimensão", 10);
       saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
       ArrayList<Golpe>golpes = saga.getGolpes();
       assertEquals(outraDimensao, golpes.get(0));
       assertEquals(1, golpes.size());
    }
    @Test

    public void aprenderDoisGolpes() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        ArrayList<Golpe>golpes = saga.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(2, golpes.size());
    }
    @Test

    public void aprenderTresGolpes() throws Exception {
        Saint saga = new GoldSaint("Saga","Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        ArrayList<Golpe> golpes = saga.getGolpes(); 
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(sataImperial, golpes.get(2));
    }
    @Test
    public void aprenderQuatroGolpesENaoLancaMaisErro() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        Golpe rasteira = new Golpe("Rasteira", 2);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        saga.aprenderGolpe(rasteira);
    }
    @Test
    public void getProximoGolpeComUm() throws Exception {
        Saint saga = new GoldSaint("Saga","Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }
    @Test

    public void getProximoGolpeComDois() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }
    @Test

    public void getProximoGolpeComTres() throws Exception {
        Saint saga = new GoldSaint("Saga","Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
    }
    @Test
    public void getProximoGolpeComQuatroChamadas() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }
    @Test
    public void getCSVComArmaduraVestidaAgoraComConstelacaoTouro() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Touro");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        String esperado = "Dohko,10.0,Touro,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, dohko.getCSV());
    }
    @Test
    public void getCSVSemArmaduraVestida() throws Exception {
        Saint june = new BronzeSaint("June","Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }
    @Test
    public void getCSVComNomeNulo() throws Exception {
        Saint june = new BronzeSaint(null, "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "null,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }
}