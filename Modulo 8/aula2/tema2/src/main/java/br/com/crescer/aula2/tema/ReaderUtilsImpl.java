/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.tema;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class ReaderUtilsImpl implements ReaderUtils{

    @Override
    public String read(String string) {
        if (string == null || string.trim().isEmpty()){
            return string;
        }       
         try {
             if (string.contains(".txt")){
             final Reader reader = new FileReader(string);
             final BufferedReader bufferReader= new BufferedReader(reader); 
              string = bufferReader.readLine();
            } 
            } catch (FileNotFoundException e) {
             e.printStackTrace();
            } catch (IOException ex) {
            Logger.getLogger(ReaderUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return string;
    }
}
