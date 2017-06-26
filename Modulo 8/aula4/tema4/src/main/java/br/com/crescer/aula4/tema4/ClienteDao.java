/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package br.com.crescer.aula4.tema4;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public class ClienteDao implements CrudDao<Cliente,Long> {
    private final  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final  Session session = entityManager.unwrap(Session.class);
    

    @Override
    public Cliente save(Cliente cliente) {
       entityManager.getTransaction().begin();
       session.save(cliente); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();
       return cliente;  
    }

    @Override
    public void remove(Cliente cliente) {
       Object persistentInstance = session.load(Cliente.class, cliente.getId());
       entityManager.getTransaction().begin();
       session.delete(persistentInstance); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();  
    }

    @Override
    public Cliente loadById(Long id) {
       Cliente cliente = new Cliente();
       entityManager.getTransaction().begin();
       cliente = (Cliente) session.get(Cliente.class, id);
       entityManager.close();
       entityManagerFactory.close();   
       return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        entityManager.getTransaction().begin();
        Criteria criteria = session.createCriteria(Cliente.class);
        List<Cliente> clienteLista =  criteria.list();
        entityManager.close();
        entityManagerFactory.close(); 
        return clienteLista; 
    }
}