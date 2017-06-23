/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author mateus.silva
 */

public final class RunDao {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();

    public  void inserir (Cliente cliente){
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();   
        em.close();
        emf.close();
    }
    
    public void deletar (Cliente cliente){
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();   
        em.close();
        emf.close();
    }
    
      public void alterar(Cliente cliente){
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();   
        em.close();
        emf.close();
    }
      
       public Cliente  getCliente(Cliente cliente){
        em.getTransaction().begin();      
        Cliente clienteRetornado = em.find(Cliente.class, 1L);     
        em.close();
        emf.close();
        return clienteRetornado;
    }
    
    
}
