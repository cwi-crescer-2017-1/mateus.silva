/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.tema3;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mateus
 */
public class NewClass {
    public static void main (String [] args) throws SQLException, FileNotFoundException, IOException{
    SQLUtilsImpl a = new SQLUtilsImpl();
        a.runFile("sql.sql");
//    
   
    
//    ScriptRunner runner = new ScriptRunner(ConnectionUtils.getConeccao(),true , true);
//               runner.runScript(new BufferedReader(new FileReader("sql.sql")));
}
}