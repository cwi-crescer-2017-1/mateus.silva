/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.tema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class NewClass {
    public static void main (String [] args) throws IOException{
//            try {
//        final Writer writer = new FileWriter("a.txt");
//        final BufferedWriter bufferedWriter= new BufferedWriter(writer);
//        
//                bufferedWriter.append("oi");
//                bufferedWriter.newLine();
//                bufferedWriter.flush();
//        } catch (IOException e) {
//             e.printStackTrace();
//        }
//            
//           try {
//             final Reader reader = new FileReader("a.txt");
//             final BufferedReader bufferReader = new BufferedReader(reader); 
//             int a = bufferReader.readLine().length();
//             System.out.println(a);
//            } 
//             catch (FileNotFoundException e) {
//             e.printStackTrace();
//            }
String string = "a.txt";
       try {
             if (string.contains(".txt")){
             final Reader reader = new FileReader(string);
             final BufferedReader bufferReader = new BufferedReader(reader); 
              StringBuffer files = new StringBuffer();
    
              System.out.println(   bufferReader.readLine());
            } 
            } catch (FileNotFoundException e) {
             e.printStackTrace();
            } catch (IOException ex) {
            Logger.getLogger(ReaderUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
}
       System.out.println(string);
}
}
