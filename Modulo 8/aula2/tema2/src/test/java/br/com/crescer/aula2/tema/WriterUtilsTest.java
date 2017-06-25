/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.tema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class WriterUtilsTest {
    
   private static final String TARGET_PATH = "target";

    private final WriterUtils writerUtils;

    private String filename;

    public WriterUtilsTest() {
        this.writerUtils = new WriterUtilsImpl();
    }

    @Before
    public void setBefore() throws IOException {
        this.filename = TARGET_PATH + "/" + new Date().getTime() + "/testWrite.txt";
        Files.createDirectories(Paths.get(filename).getParent());
    }

    @Test
    public void testWrite() throws IOException {
        final String test = "teste de inclusão " + new Date().getTime();
        writerUtils.write(filename, test);
        assertTrue(reader.read(filename).contains(test));
    }

       private final WriterUtils instance = new WriterUtilsImpl();
       private final ReaderUtils reader = new ReaderUtilsImpl();

    @Test
    public void escrever(){
        instance.write("a.txt", "oi");
        assertEquals(true, reader.read("a.txt").contains("oi"));
    }
 
    
}
