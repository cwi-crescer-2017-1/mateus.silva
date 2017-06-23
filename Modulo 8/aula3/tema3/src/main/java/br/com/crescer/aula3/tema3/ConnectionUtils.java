package br.com.crescer.aula3.tema3;

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
public final class ConnectionUtils {
    
    public static Connection getConeccao() throws SQLException{
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "ORACLE";
        final String pass = "ORACLE";
        return  DriverManager.getConnection(url, user, pass);        
    }
}
