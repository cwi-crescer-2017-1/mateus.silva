/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.tema3;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Mateus
 */
public class NewClass {
    public static void main (String [] args) throws SQLException, FileNotFoundException, IOException{

    SQLUtilsImpl a = new SQLUtilsImpl();
 //a.exportCSV("SELECT*FROM pais");
  //
  
  a.importCSV(new File("pais.csv"));

}
}