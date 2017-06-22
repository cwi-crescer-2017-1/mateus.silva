/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;


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
//Pais p = new Pais();
//p.setNome("Antina");
//p.setSigla("ARG");
//p.setId(3l);
//////Long id = 1L;
////
PaisDaoImpl model = new PaisDaoImpl();
//Estado e = new Estado();
 System.out.println(model.loadBy(1l).getNome());
//e.setNome("Arewela");
//e.setUf("RS");
//e.setPais(400l);
//e.setId(445l);
EstadoDaoImpl es = new EstadoDaoImpl();
//es.delete(e);

Cidade cidade = new Cidade ();
cidade.setNome("odsdasasi");
cidade.setEstado(13234l);
cidade.setId(3423434l);
CidadeDaoImpl c = new CidadeDaoImpl();
c.delete(cidade);

//System.out.println(c.loadBy(1l).getEstado());

//System.out.println(es.loadBy(1l).getNome());
}
}