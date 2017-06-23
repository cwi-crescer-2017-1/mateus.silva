/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author mateus.silva
 */
public class Hibernate {
    public static void main (String []args){
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
     
        final Cliente cliente = new Cliente(); 
        cliente.setId(1l);
        cliente.setNome("Mateus");
        final Session session = em.unwrap(Session.class);
        em.getTransaction().commit();
        session.saveOrUpdate(cliente);
        em.close();
        emf.close();
    }
}
