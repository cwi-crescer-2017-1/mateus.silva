/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.tema3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File importCSV(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
