/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1.tema;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateus.silva
 */
public class JurosSimplesTest {
    
    public JurosSimplesTest() {
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

    /**
     * Test of calcular method, of class JurosSimples.
     */
    @org.junit.Test
    public void testCalcular() {
        System.out.println("calcular");
        BigDecimal valorParcelar = null;
        int numeroParcelas = 0;
        double taxaJuros = 0.0;
        Date dataPrimeiroVencimento = null;
        JurosSimples instance = new JurosSimples();
        Map<String, BigDecimal> expResult = null;
        Map<String, BigDecimal> result = instance.calcular(valorParcelar, numeroParcelas, taxaJuros, dataPrimeiroVencimento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
