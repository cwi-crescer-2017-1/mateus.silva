/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

/**
 *
 * @author mateus.silva
 */
public class ExemploDDL {


    public static void main(String[] args) {
//       TesteDao dao = new TesteDao();
//        dao.drop();
//        dao.create();
//        dao.insert();
Pais p = new Pais();
p.setNome("Argentina");
p.setSigla("ARG");
Long id = 1L;
p.setId(2L);
PaisDaoImpl model = new PaisDaoImpl();
model.insert(p);
Estado e = new Estado();

//System.out.println(model.loadBy(1L));
     
}
}