/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Services;

import br.com.crescer.aula7.tema.Entities.Video;
import br.com.crescer.aula7.tema.Repositories.VideoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;
           
    public Video save (Video video){
        return videoRepository.save(video);
    }
    
    public void remove (Video video){
      videoRepository.delete(video);
    }

     public void removeById (Long id){
        videoRepository.delete(id);
    }
    public Video  loadById(Long id){
        return videoRepository.findOne(id);
    }

    public List <Video> findAll (){
       return  (List<Video>) videoRepository.findAll();
    }
    
      public void put(Video video){
        videoRepository.save(video);
    }
}
