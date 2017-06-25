/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.tema4;

import java.math.BigDecimal;

/**
 *
 * @author Mateus
 */
public class NewClass {
    public static void main(String [] args){
       ClienteDaoImpl c = new ClienteDaoImpl();
      FuncionarioDaoImpl f = new FuncionarioDaoImpl();
                VideoDaoImpl vd = new VideoDaoImpl();
//
//       Locacao l = new Locacao();
//       LocacaoDaoImpl fda = new  LocacaoDaoImpl ();
//        l.setId(1l);
//        l.setCliente(c.loadById(150l));
//        
//       l.setFuncionario(f.loadById(450l));
//       l.setVideos(vd.loadById(50l));
//       l.setValorTotal(new BigDecimal(23));
//        LocacaoDaoImpl dao = new LocacaoDaoImpl();
        
        //dao.save(l);
        System.out.println(vd.loadById(50l).getNome());
    }
}
