/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.tema;

import java.io.File;
import java.io.IOException;
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
public class WriterUtilsTest {
    
    public WriterUtilsTest() {
    }
    
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

       private final WriterUtils instance = new WriterUtilsImpl();
       private final ReaderUtils reader = new ReaderUtilsImpl();

    @Test
    public void escrever(){
        instance.write("a.txt", "oi");
        assertEquals("oi", reader.read("a.txt"));
    }
 
    
}
