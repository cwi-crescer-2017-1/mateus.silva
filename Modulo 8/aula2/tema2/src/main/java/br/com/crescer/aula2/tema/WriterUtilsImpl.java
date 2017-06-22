/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.tema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

/**
 *
 * @author Mateus
 */
public class WriterUtilsImpl implements WriterUtils{

    @Override
    public void write(String file, String conteudo) {
        if(isEmpty(file)|| isEmpty(conteudo)){
            return;
        }
        if (file.contains(".txt")){
            try {
         FileWriter writer = new FileWriter(file, true);
         BufferedWriter bufferedWriter = new BufferedWriter(writer);    
         bufferedWriter.append(conteudo);
         bufferedWriter.newLine();    
         bufferedWriter.flush();
        } catch (IOException e) {
             e.printStackTrace();
        }
        }
    }
     public static boolean isEmpty(String string){
        return string == null || string.isEmpty();
    }
     
           
           
}
//src: https://stackoverflow.com/questions/13938886/write-file-without-deleting-older-data