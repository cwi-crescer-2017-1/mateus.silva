/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.tema3;



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
   a.exportCSV("SELECT*FROM ESTADO");
   // new File("oi.txt").createNewFile();
   // PrintWriter pw = new PrintWriter(new File("oi.txt"));
//        StringBuilder sb = new StringBuilder();
//        sb.append("id");
//        sb.append(',');
//        sb.append("Name");
//        sb.append('\n');
//
//        sb.append("1");
//        sb.append(',');
//        sb.append("Prashant Ghimire");
//        sb.append('\n');
//
//        pw.write(sb.toString());
//        pw.close();
//        System.out.println("done!");
    
//    ScriptRunner runner = new ScriptRunner(ConnectionUtils.getConeccao(),true , true);
//               runner.runScript(new BufferedReader(new FileReader("sql.sql")));
}
}