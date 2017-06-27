/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.tema4;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public class NewClass {
    public static void main(String [] args){
  
//     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
//     EntityManager entityManager = entityManagerFactory.createEntityManager();
//      Session session = entityManager.unwrap(Session.class);
    
   Funcionario funcionario = new Funcionario ();
    Cliente cliente = new Cliente();
    Video video = new Video();
    Genero genero = new Genero();
    Locacao locacao = new Locacao();
    ClienteDao  clienteDao = new ClienteDao();
   FuncionarioDao funcionarioDao = new FuncionarioDao();
GeneroDao generoDao = new GeneroDao();
//    VideoDao videoDao = new VideoDao();
    LocacaoDao locacaoDao = new LocacaoDao();
//
  generoDao.findAll();
    funcionario.setNome("Mateus");
    funcionario.setRg("dadsad");
       funcionarioDao.save(funcionario);
//    cliente.setNome("Alziro");
//    cliente.setCelular("324334");
//    cliente.setId(1l);
//    cliente.setCpf("234342432");
//    genero.setDescricao("drama");
//    genero.setId(1l);
//    video.setGenero(genero);
//    video.setId(1l);
//    video.setValor(new BigDecimal (123));
   locacao.setValorTotal(new BigDecimal(34));
//    locacao.setId(1l);
    locacao.setFuncionario(funcionario);
   locacao.setCliente(clienteDao.loadById(50l));
  
    locacao.setDataDevolucao(new Date());
    locacaoDao.save(locacao);


//     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
//     EntityManager entityManager = entityManagerFactory.createEntityManager();
//     Session session = entityManager.unwrap(Session.class);
 
//Connection connection = new Connection();
//connection.iniciarConeccao();
  cliente.setCelular("33434");
  cliente.setNome("fffdfd");
  cliente.setCpf("rwwrr");
//  funcionario.setNome("sdsdds");
//  funcionario.setRg("232e443");
//  funcionarioDao.save(funcionario);
//     // entityManager.getTransaction().begin();
   //clienteDao.save(cliente);

//clienteDao.save(cliente);
//connection.fecharConeccao();
//  

        }
}
