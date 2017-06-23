/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.tema3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class SQLUtilsImpl implements SQLUtils {

    @Override
    public void runFile(String filename) {
     if (filename.endsWith(".sql")){
         try {
               ScriptRunner runner = new ScriptRunner(ConnectionUtils.getConeccao(),true , true);
               runner.runScript(new BufferedReader(new FileReader(filename)));
         } catch (SQLException | IOException ex) {
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
                while (resultSet.next()){
                    ResultSetMetaData meta = resultSet.getMetaData();
                         for (int i = 1; i <= meta.getColumnCount(); i++) {
                            resultado.append(meta.getColumnLabel(i)).append("\t").append("\n");
                         }
                         for (int i = 1; i <= meta.getColumnCount(); i++) {
                              resultado.append(resultSet.getObject(i) + "\t").append("\t").append("\n");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File exportCSV(String query) {
       write("oi.csv", executeQuery(query).replaceAll("\t", ","));      
       return new File("oi.csv");
       //não está escrevendo em csv apenas em txt;
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
}
