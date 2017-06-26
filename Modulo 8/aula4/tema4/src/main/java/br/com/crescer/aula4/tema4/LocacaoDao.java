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
public class LocacaoDao implements CrudDao<Locacao, Long> {
  
    private final  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final  Session session = entityManager.unwrap(Session.class);
    
    @Override
    public Locacao save(Locacao locacao) {
       entityManager.getTransaction().begin();
       session.save(locacao); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();
       return locacao;
    }

    @Override
    public void remove(Locacao locacao) {
       Object persistentInstance = session.load(Locacao.class, locacao.getId());
       entityManager.getTransaction().begin();
       session.delete(persistentInstance); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();
    }

    @Override
    public Locacao loadById(Long id) {
       Locacao locacao = new Locacao();
       entityManager.getTransaction().begin();
       locacao = (Locacao) session.get(Locacao.class, id);
       entityManager.close();
       entityManagerFactory.close();   
       return locacao;
    }

    @Override
    public List<Locacao> findAll() {
        entityManager.getTransaction().begin();
        Criteria criteria = session.createCriteria(Locacao.class);
        List<Locacao> locacaoLista =  criteria.list();
        entityManager.close();
        entityManagerFactory.close(); 
        return locacaoLista;
    }
}
