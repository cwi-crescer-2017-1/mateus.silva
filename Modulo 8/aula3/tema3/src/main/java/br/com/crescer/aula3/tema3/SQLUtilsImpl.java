/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.tema3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class SQLUtilsImpl implements SQLUtils {

    @Override
    public void runFile(String filename) {
        if (!filename.endsWith(".sql")){
           throw new RuntimeException (); 
        }    
       String [] queries =  read(filename).split(";");
       for (String query : queries){
            try (final PreparedStatement preparedStatement = ConnectionUtils.getConeccao().prepareStatement(query)) {
                preparedStatement.executeQuery();
            }
             catch (SQLException ex) {
                 Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }         
 }
    
    @Override
    public String executeQuery(String query) {
      StringBuilder resultado = new StringBuilder();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConeccao().prepareStatement(query)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                  ResultSetMetaData meta = resultSet.getMetaData();
                    for (int i = 1; i <= meta.getColumnCount(); i++) {
                            resultado.append(meta.getColumnLabel(i)).append("\t");
                       }    
                    resultado.append(",");
                    int contador = 1;
                while (resultSet.next()){    
                    
                         for (int i = 1; i <= meta.getColumnCount(); i++) {
                            
                            if (meta.getColumnTypeName(i).contains("VARCHAR2")){
                                 resultado.append("'"+resultSet.getObject(i)+"'").append("\t");
                            }
                           else{
                              resultado.append(resultSet.getObject(i)).append("\t");
                                    }
                                           
                           if (contador ==  meta.getColumnCount()) 
                           {
                               resultado.append(",");
                               contador =1;
                               break;
                           }
                            contador++;
                        }
                }    
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    return resultado.toString();
    }

    @Override 
    public void importCSV(File file) {
            String insert = "INSERT INTO " + file.getName().replaceAll(".csv", "");
            String leitura = read(file.getName());
            String[] frase = (leitura).split(",,");
            String b = frase[0];
            String query;
            for(int i = 1; i< frase.length -1; i++){
                String a = frase.toString();
                query ="";
            query =  insert + "("+ b +")"+"values" + "(" + frase[i] + ")";
            try (final PreparedStatement preparedStatement = ConnectionUtils.getConeccao().prepareStatement(query)) {
                    preparedStatement.executeUpdate();
                
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            } 
             }
    }

    @Override
    public File exportCSV(String query) {
       write("oi.csv", executeQuery(query).replaceAll("\t", ","));      
       return new File("oi.csv");
    }
    
     public void write(String file, String conteudo) {
        if(isEmpty(file)|| isEmpty(conteudo)){
            return;
        }
        if (file.contains(".csv")){
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
        return string == null || string.trim().isEmpty();
    }
     
     public String read(String string) {
        if (string == null || string.trim().isEmpty()){
            return string;
        }    
         try {
             if (string.contains(".sql")|| string.endsWith(".csv")){      
             final BufferedReader bufferReader= new BufferedReader(new FileReader(string)); 
              string ="";
             while (true) {
                        String readLine = bufferReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        string = string + readLine + "\n ";
                    }
            } 
            } catch (FileNotFoundException e) {
             e.printStackTrace();
            } catch (IOException ex) {
        }
         return string;
    }
}
