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
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Mateus
 */
public class VideoDao implements CrudDao <Video, Long>{
    private  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private  Session session = entityManager.unwrap(Session.class);

    @Override
    public Video save(Video video) {
       entityManager.getTransaction().begin();
       session.save(video); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();
       return video;  
    }
    @Override
    public void remove(Video video) {
       Object persistentInstance = session.load(Video.class, video.getId());
       entityManager.getTransaction().begin();
       session.delete(persistentInstance); 
       entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();  
    }

    @Override
    public Video loadById(Long id) {
       Video video = new Video();
       entityManager.getTransaction().begin();
       video = (Video) session.get(Video.class, id);
       entityManager.close();
       entityManagerFactory.close(); 
//        session.close();
       return video;   
    }

    @Override
    public List<Video> findAll() {
        entityManager.getTransaction().begin();
        Criteria criteria = session.createCriteria(Video.class);
        List<Video> videosLista =  criteria.list();
        entityManager.close();
        entityManagerFactory.close(); 
        return videosLista;    
    }
    
}
