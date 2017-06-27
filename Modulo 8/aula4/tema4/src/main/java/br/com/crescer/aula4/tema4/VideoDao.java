/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.tema4;

import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Mateus
 */
public class VideoDao implements CrudDao <Video, Long>{
    private  final  Connection connection = new Connection();
    @Override
    public Video save(Video video) {
       connection.getSession().saveOrUpdate(video); 
       connection.fecharConeccao();
       return video;
    }

    @Override
    public void remove(Video video) {
       Object persistentInstance =  connection.getSession().load(Video.class, video.getId());
       connection.getSession().delete(persistentInstance); 
       connection.fecharConeccao();
    }

    @Override
    public Video loadById(Long id) {
       Video video;
       video = (Video) connection.getSession().get(Video.class, id);
       connection.fecharConeccao();
       return video;
    }

    @Override
    public List<Video> findAll() {
        Criteria criteria =  connection.getSession().createCriteria(Video.class);
        List<Video> videoLista =  criteria.list();
        connection.fecharConeccao();
        return videoLista;
    }
    
}
