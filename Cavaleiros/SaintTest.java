import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception{
        Armadura fenix = new Armadura (new Constelacao ("Fenix"), Categoria.BRONZE);
        Saint ikki  = new Saint ("Ikki", fenix);
        ikki.vestirArmadura();
        boolean resultado = ikki.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    @Test
    public void naoVestirArmarduraDeixaArmaduraNaoVestida()throws Exception{
        GoldSaint ionia = new GoldSaint ("Ionia", new Armadura (new Constelacao ("Capricórnio"), Categoria.OURO));
        assertEquals (false, ionia.getArmaduraVestida());
    }
    @Test
    public void aoCriarSaintGeneroENaoInformado()throws Exception{
        Armadura cobra = new Armadura (new Constelacao ("Cobra"), Categoria.PRATA);
        Saint shina = new Saint ("Shina", cobra);
        assertEquals(Genero.NAO_INFORMADO, shina.getGenero());
    }
    @Test 
    public void aoCriarSaintStatusDeveSerVivo()throws Exception{
        GoldSaint shaka = new GoldSaint ("Shaka", new Armadura (new Constelacao ("Virgem"), Categoria.OURO));
        assertEquals(Status.VIVO, shaka.getStatus());
    }
    @Test
    public void aoCriarSaintVidaDeveSer100()throws Exception{
        GoldSaint shaka = new GoldSaint ("Shaka", new Armadura (new Constelacao ("Virgem"), Categoria.OURO));
        assertEquals(100.0, shaka.getVida(),0.01);
    }
    @Test 
    public void retornaOValorIntDaCategoria ()throws Exception{
        Saint shion = new Saint ("Shion", new Armadura (new Constelacao ("Áries"), Categoria.OURO));
        int valor = shion.getValorDaCategoria();
        assertEquals (3, valor);
    }
     @Test 
    public void perde10deVidaAoSofrerGolpe ()throws Exception{
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        double delta  = 0.0000001;
        seiya.perderVida(10);
        assertEquals (90, seiya.getVida(), delta);
    }
     @Test 
    public void perde100deVidaAoSofrerGolpe ()throws Exception{
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        double delta  = 0.0000001;
        seiya.perderVida(100);
        assertEquals (0, seiya.getVida(), delta);
    }
    @Test 
    public void deveRetonarONomeDoSaint ()throws Exception{
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));  
        String nome = seiya.getNome();
        int nomeInt = nome.compareTo("Seiya");
        assertEquals(0, nomeInt);
    }
    @Test 
    public void deveRetornaVidaDoSaint ()throws Exception{
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));  
        double delta  = 0.0000001;
        assertEquals(100,seiya.getVida(), delta);
    }
    @Test 
    public void deveMudarOGeneroDoSaint ()throws Exception{
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));   
        Genero genero = Genero.MASCULINO;
        seiya.setGenero(genero);
        assertEquals (Genero.MASCULINO,seiya.getGenero());
    }
    @Test 
    public void retornaOGeneroDoSaint ()throws Exception{
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));   
        assertEquals (Genero.NAO_INFORMADO,seiya.getGenero());
    }
    @Test
    public void acriarSaintNasceCom5SentidosDespertados()throws Exception{
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE)); 
        assertEquals(5,seiya.getQtsSentidosDespertados());
    }
    @Test
    public void acriarSaintNasceCom6SentidosDespertados()throws Exception{
        SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
        assertEquals(6,seiya.getQtsSentidosDespertados());
    }
    @Test
    public void acriarSaintNasceCom7SentidosDespertados()throws Exception{
        GoldSaint mu = new GoldSaint ("Mu", new Armadura (new Constelacao ("Touro"), Categoria.OURO)); 
        assertEquals(7,mu.getQtsSentidosDespertados());
    }
    @Test
    public void mudaStatusParaMortoQuandoAVidaForMenorQue1 ()throws Exception{
        SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
        seiya.perderVida(110);
        assertEquals(Status.MORTO,seiya.getStatus());
    }
    @Test
    public void  evitarQueSaintTenhaSuaVidaEStatusAlteradoQuandoEstiverMorto () throws Exception{
        SilverSaint seiya = new SilverSaint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.PRATA)); 
        seiya.perderVida(100);
        assertEquals(Status.MORTO,seiya.getStatus());
        seiya.perderVida(10);
        assertEquals(0, seiya.getVida(),0.001);
        assertEquals(Status.MORTO,seiya.getStatus());
    }
    //@Test 
    //public void darErroInvalidParameterExceptionQuandoDanoDoGolpeForNegativo()throws Exception{
    //    Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));
     //   double delta  = 0.0000001;
    ///    seiya.perderVida(-1000);
    //    assertEquals (1100, seiya.getVida(), delta);
   // }
   @Test
   public void insereOGolpeNaConstelacaoDoSaint ()throws Exception{
       Constelacao virgem = new Constelacao ("Virgem");
       GoldSaint shaka = new GoldSaint ("Shaka", new Armadura (virgem, Categoria.OURO));
        Golpe golpe1 = new Golpe ();
        shaka.aprenderGolpe(golpe1);
        assertEquals(shaka.getGolpes()[2],golpe1); 
   }
  
       
}