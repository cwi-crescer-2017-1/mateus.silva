package br.com.crescer.aula2.tema;


import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateus
 */
public class FileUtisImpl implements FileUtis {

    @Override
    public boolean mk(String string) {
        if (isEmpty(string)){
            return false;
        }
        try {
            final File file = new File(string);
            if (file.isFile()){
                return file.createNewFile();
            }
            else {
                return  file.mkdirs();
            }
        }  
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
   }
    
    @Override
    public boolean rm(String string) {
        if (isEmpty(string)){
            return false;
        }
        final File file = new File(string);
        if (string.endsWith(".txt")|| file.isFile()) {
            return file.delete();         
        }
        else {
            System.out.println("Arquivo Inválido");
            throw new RuntimeException ();  
        } 
    }

    @Override
    public String ls(String string) {
        if (isEmpty(string)){
            return string;
        }
        final File file = new File(string);
        if (!string.endsWith(".txt") && file.isDirectory()) {
            StringBuffer files = new StringBuffer();
            for (String f: file.list()){
                files.append(f).append(" ");
            }
         return files.toString().trim();
        }
        if (string.endsWith(".txt")|| file.isFile()) {
            return file.getAbsolutePath();
        }     
        return string.trim();
    }

    //recebe um arquivo e um path?
    @Override
    public boolean mv(String in, String out) {
        if (isEmpty(in)){
            return false;
      }
        final File file = new File(in);
        if (!in.endsWith(".txt")&& file.isDirectory()) {
            System.out.println("Arquivo Inválido");
            throw new RuntimeException ();  
        }
        else {
            file.renameTo(new File (out + file.getName()));
            return  true;
        }
    }
    
    public static boolean isEmpty(String string){
        return string == null || string.trim().isEmpty();
    }
}
