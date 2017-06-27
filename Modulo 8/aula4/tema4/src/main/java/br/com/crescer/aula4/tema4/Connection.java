/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.tema4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public final class Connection {
   final  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
   final   EntityManager entityManager = entityManagerFactory.createEntityManager();
   final  Session session = entityManager.unwrap(Session.class);
    
 public  Session getSession(){
    return     session;
 }
 
 public  void iniciarConeccao(){
    entityManager.getTransaction().begin();
 }
   
    
 public  void fecharConeccao(){
    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
 }
}
