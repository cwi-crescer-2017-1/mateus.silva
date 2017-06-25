/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.tema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class ReaderUtilsTest {

  
    private static final String TARGET_PATH = "target";

    private final ReaderUtils readerUtils;

    private String filename;

    public ReaderUtilsTest() {
        this.readerUtils = new ReaderUtilsImpl();
    }

    @Before
    public void setBefore() throws IOException {
        this.filename = TARGET_PATH + "/" + new Date().getTime() + "/testRead.txt";
        final Path path = Paths.get(filename);
        Files.createDirectories(path.getParent());
        Files.createFile(path);
        Files.write(path, filename.getBytes());
    }

    @Test
    public void testRead() {
        final String read = readerUtils.read(filename);
        assertNotNull(read);
        assertEquals(filename, read);
    }

   private final WriterUtils escrever = new WriterUtilsImpl();
   private final ReaderUtils instance = new ReaderUtilsImpl();

    @Test
    public void readFile() {
       escrever.write("a.txt", "oi");
       escrever.write("a.txt", "1i");
       assertEquals(true, instance.read("a.txt").contains("oi"));
    }
}
