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
public class GeneroDao implements CrudDao <Genero, Long> {
    private  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private  Session session = entityManager.unwrap(Session.class);
    
    @Override
    public Genero save(Genero genero) {
       entityManager.getTransaction().begin();
       session.save(genero); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();
       return genero;   
    }

    @Override
    public void remove(Genero genero) {
       Object persistentInstance = session.load(Genero.class, genero.getId());
       entityManager.getTransaction().begin();
       session.delete(persistentInstance); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();   
    }

    @Override
    public Genero loadById(Long id) {
       Genero genero = new Genero();
       entityManager.getTransaction().begin();
       genero = (Genero) session.get(Genero.class, id);
       entityManager.close();
       entityManagerFactory.close();   
       return genero;  
    }

    @Override
    public List<Genero> findAll() {
        entityManager.getTransaction().begin();
        Criteria criteria = session.createCriteria(Genero.class);
        List<Genero> generoLista =  criteria.list();
        entityManager.close();
        entityManagerFactory.close(); 
        return generoLista;    
    }   
}
