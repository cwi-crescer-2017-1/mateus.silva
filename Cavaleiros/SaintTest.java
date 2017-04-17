import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida(){
        Armadura fenix = new Armadura ("Fênix", Categoria.BRONZE);
        Saint ikki  = new Saint ("Ikki", fenix);
        ikki.vestirArmadura();
        boolean resultado = ikki.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    @Test
    public void naoVestirArmarduraDeixaArmaduraNaoVestida(){
        Saint ionia = new Saint ("Ionia", new Armadura ("Capricónio", Categoria.OURO));
        assertEquals (false, ionia.getArmaduraVestida());
    }
    @Test
    public void aoCriarSaintGeneroENaoInformado(){
        Armadura cobra = new Armadura ("Cobra", Categoria.PRATA);
        Saint shina = new Saint ("Shina", cobra);
        assertEquals(Genero.NAO_INFORMADO, shina.getGenero());
    }
    @Test 
    public void aoCriarSaintStatusDeveSerVivo(){
        Saint shaka = new Saint ("Shaka", new Armadura ("Virgem", Categoria.OURO));
        assertEquals(Status.VIVO, shaka.getStatus());
    }
    @Test
    public void aoCriarSaintVidaDeveSer100(){
        Saint shaka = new Saint ("Shaka", new Armadura ("Virgem", Categoria.OURO));
        assertEquals(100.0, shaka.getVida(),0.01);
    }
    @Test 
    public void retornaOValorStringDaCategoria(){
        Saint shaka = new Saint ("Shaka", new Armadura ("Virgem", Categoria.OURO));
        String valor = shaka.getValorStringDaCategoria();
        int valorInt =  valor.compareTo("OURO");
        assertEquals(0,valorInt);
    }
        @Test 
    public void retornaOValorIntDaCategoria (){
        Saint shion = new Saint ("Shion", new Armadura ("Áries", Categoria.OURO));
        int valor = shion.getValorDaCategoria();
        assertEquals (3, valor);
    }
    @Test 
    public void iniciaBatalhaCavaleiroDeMenorCategoriaDevePederDezDeVida (){
        Batalha b = new Batalha();
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));
        Saint shion = new Saint ("Shion", new Armadura ("Áries", Categoria.OURO));
        double delta  = 0.0000001;
        b.iniciar(seiya, shion);
        assertEquals (90, seiya.getVida(), delta );
    }
    @Test 
    public void perde10deVidaAoSofrerGolpe (){
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));
        double delta  = 0.0000001;
<<<<<<< Updated upstream
        seiya.perderVida(90);
        assertEquals (10, seiya.getVida(), delta);
<<<<<<< Updated upstream
        seiya.perderVida(10);
        assertEquals (90, seiya.getVida(), delta);
=======
=======
        seiya.perderVida(10);
        assertEquals (90, seiya.getVida(), delta);
>>>>>>> Stashed changes
>>>>>>> Stashed changes
    }
     @Test 
    public void perde100deVidaAoSofrerGolpe (){
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));
        double delta  = 0.0000001;
        seiya.perderVida(100);
        assertEquals (0, seiya.getVida(), delta);
    }
     @Test 
    public void perdeMenos1000deVidaAoSofrerGolpe (){
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));
        double delta  = 0.0000001;
        seiya.perderVida(-1000);
        assertEquals (1100, seiya.getVida(), delta);
    }
       @Test 
    public void deveRetonarONomeDoSaint (){
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));  
        String nome = seiya.getNome();
        int nomeInt = nome.compareTo("Seiya");
        assertEquals(0, nomeInt);
    }
    @Test 
    public void deveRetornaVidaDoSaint (){
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));  
        double delta  = 0.0000001;
        assertEquals(100,seiya.getVida(), delta);
    }
    @Test 
    public void deveMudarOGeneroDoSaint (){
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));   
        Genero genero = Genero.MASCULINO;
        seiya.setGenero(genero);
        assertEquals (Genero.MASCULINO,seiya.getGenero());
    }
    @Test 
    public void retornaOGeneroDoSaint (){
        Saint seiya = new Saint ("Seiya", new Armadura ("Pégaso", Categoria.BRONZE));   
        assertEquals (Genero.NAO_INFORMADO,seiya.getGenero());
    }
}