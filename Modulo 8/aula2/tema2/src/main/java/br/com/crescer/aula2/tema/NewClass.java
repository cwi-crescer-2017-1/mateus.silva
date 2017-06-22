/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.tema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class NewClass {
    public static void main (String [] args) throws IOException{

//FileUtisImpl e = new FileUtisImpl();
//WriterUtilsImpl a = new WriterUtilsImpl ();
//e.mv("C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2\\a.txta.txt", "C:\\Users\\Mateus\\Desktop\\CWI\\mateus.silva\\Modulo 8\\aula2\\tema2\\");
//
// a.write("a.txt", "errouuu");
      
         BigDecimal multiplicador  = new BigDecimal (1 + 10.0/100);

        BigDecimal valorDaParcela = new BigDecimal(1001).multiply(multiplicador).divide(new BigDecimal (10)).setScale(2, BigDecimal.ROUND_HALF_UP);         
        int contador =1; 
System.out.println(valorDaParcela);
}
}
