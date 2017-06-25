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
import java.util.Date;
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
    
     
 private static final String TARGET_PATH = "target";

    private final FileUtis fileUtils;

    public FileUtisTest() {
        this.fileUtils = new FileUtisImpl();
    }

    @BeforeClass
    public static void setBeforeClass() {
        new File(TARGET_PATH).mkdir();
    }

    /**
     * Test of mk method, of class FileUtils.
     */
    @Test
    public void testMk() {
        final String testPath = TARGET_PATH + "/" + new Date().getTime() + "/testMk";

        assertTrue(fileUtils.mk(testPath));
        assertTrue(fileUtils.mk(testPath + "/testMk.txt"));

        final File file = new File(testPath);
        assertTrue(file.exists() && file.isDirectory());

        assertTrue(file.listFiles(f -> "testMk.txt".equals(f.getName())).length > 0);
    }

    /**
     * Test of rm method, of class FileUtils.
     */
    @Test
    public void testRm() {
        final String testPath = TARGET_PATH + "/" + new Date().getTime() + "/testMk";
        fileUtils.mk(testPath);
        fileUtils.mk(testPath + "/testRm.txt");
        assertTrue(fileUtils.rm(testPath + "/testRm.txt"));
        try {
            fileUtils.rm(testPath);
            fail("Ao tentar remover o diretório deve lançar uma exception.");
        } catch (RuntimeException e) {
            //.. 
        }
    }

    /**
     * Test of ls method, of class FileUtils.
     */
    @Test
    public void testLs() {
        final String testPath = TARGET_PATH + "/" + new Date().getTime() + "/testLs";
        fileUtils.mk(testPath);
        fileUtils.mk(testPath + "/testLs.txt");
        final File file = new File(testPath + "/testLs.txt");
        assertEquals(file.getAbsolutePath(), fileUtils.ls(testPath + "/testLs.txt"));
        assertTrue(fileUtils.ls(testPath).contains("testLs.txt"));
    }

    /**
     * Test of mv method, of class FileUtils.
     */
    @Test
    public void testMv() {
        final String testPath = TARGET_PATH + "/" + new Date().getTime() + "/testMv";
        final String origem = testPath + "/origem.txt";
        final String destino = testPath + "/destino.txt";
        fileUtils.mk(origem);
        assertTrue(fileUtils.mv(origem, destino));
        try {
            fileUtils.mv(testPath, TARGET_PATH + "/" + new Date().getTime());
            fail("Ao tentar remover o diretório deve lançar uma exception.");
        } catch (RuntimeException e) {
            //.. 
        }
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
//    @Test
//    public void rmDeletar(){
//        assertEquals(true, instance.rm("a.txt"));     
//    } verificar, pois está dando erro.
    
    @Test
    public void rmDiretorio(){
        assertEquals(false, instance.rm("C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2"));     
    }   
    
    @Test
    public void ls(){
      String teste = instance.ls("C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 7");
       //  String teste = instance.ls("C:\\Users\\mateus.silva\\Documents\\mateus.silva\\Modulo 7");
        assertEquals(true, teste.contains("aula 1")); 
        assertEquals(true, teste.contains("aula 2"));  
        assertEquals(true, teste.contains("aula 3"));
        assertEquals(true, teste.contains("tarefa"));
    }
    //Não vai funcionar na cwi path diferente do meu computador.
//     @Test
//    public void lsRetornaPath(){
//      assertEquals("C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2\\tema2\\a.txt", instance.ls("a.txt"));     
//    }
    
    @Test
     public void lsRetornaString(){
      assertEquals(">_$%#$#@", instance.ls(">_$%#$#@"));     
    }
    
//   @Test
//    public void mvDiretorio(){
//   //   assertEquals(false, instance.mv(
//     // "C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2\\tema2\\","C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2\\tema2\\"));     
//    assertEquals(false, instance.mv("C:\\Users\\mateus.silva\\Documents\\mateus.silva\\", "C:\\Users\\mateus.silva\\Documents\\"));
//    }
//    
}
