package br.com.crescer.aula2.tema;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.crescer.aula2.tema.FileUtis;
import br.com.crescer.aula2.tema.FileUtisImpl;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */

public class FileUtisTest {
    
     
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
        private final FileUtis instance =  new FileUtisImpl();


    @Test
    public void mkStringNull (){
    String teste = null;
    assertEquals (false, instance.mk(teste));   
 
    }
  
    @Test
    public void mkFile(){
       String teste = "a.txt";
       assertEquals (true, instance.mk(teste)); 
    }
    
    @Test
    public void mkException(){
       assertEquals (false, instance.mk(">_$%#$#@")); 
    }
    @Test
    public void rmStringNull(){
        assertEquals(false, instance.rm(null));     
    }
    @Test
    public void rmDeletar(){
        assertEquals(true, instance.rm("a.txt"));     
    }
    
    @Test
    public void rmDiretorio(){
        assertEquals(false, instance.rm("C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2"));     
    }   
    
    @Test
    public void ls(){
        String teste = instance.ls("C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 7");
        assertEquals(true, teste.contains("aula 1")); 
        assertEquals(true, teste.contains("aula 2"));  
        assertEquals(true, teste.contains("aula 3"));
        assertEquals(true, teste.contains("tarefa"));
    }
    
     @Test
    public void lsRetornaPath(){
      assertEquals("C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2\\tema2\\a.txt", instance.ls("a.txt"));     
    }
    
    @Test
     public void lsRetornaString(){
      assertEquals(">_$%#$#@", instance.ls(">_$%#$#@"));     
    }
    
   @Test
    public void mvDiretorio(){
      assertEquals(false, instance.mv(
      "C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2\\tema2\\","C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2\\tema2\\"));     
    }
    
}
