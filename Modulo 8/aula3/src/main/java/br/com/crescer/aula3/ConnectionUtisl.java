/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

/**
 *
 * @author mateus.silva
 */
public final class ConnectionUtisl {
    
    public static Connection getConeccao() throws SQLException{
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "ORACLE";
        final String pass = "ORACLE";
        return  DriverManager.getConnection(url, user, pass);        
    }
}
