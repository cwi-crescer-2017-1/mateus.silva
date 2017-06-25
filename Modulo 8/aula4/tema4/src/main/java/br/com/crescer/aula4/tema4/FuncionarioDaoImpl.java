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
public class FuncionarioDaoImpl implements FuncionarioDao {

    private  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private  Session session = entityManager.unwrap(Session.class);
    
    @Override
    public Funcionario save(Funcionario funcionario) {
       entityManager.getTransaction().begin();
       session.save(funcionario); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();
       return funcionario;
    }

    @Override
    public void remove(Funcionario funcionario) {
       Object persistentInstance = session.load(Funcionario.class, funcionario.getId());
       entityManager.getTransaction().begin();
       session.delete(persistentInstance); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();
    }

    @Override
    public Funcionario loadById(Long id) {
       Funcionario funcionario = new Funcionario();
       entityManager.getTransaction().begin();
       funcionario = (Funcionario) session.get(Funcionario.class, id);
       entityManager.close();
       entityManagerFactory.close();   
       return funcionario;
    }

    @Override
    public List<Funcionario> findAll() {
        entityManager.getTransaction().begin();
        Criteria criteria = session.createCriteria(Funcionario.class);
        List<Funcionario> funcionarioLista =  criteria.list();
        entityManager.close();
        entityManagerFactory.close(); 
        return funcionarioLista;
    }
    
}
