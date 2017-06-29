/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Controllers;

import br.com.crescer.aula7.tema.Entities.Video;
import br.com.crescer.aula7.tema.Services.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mateus
 */
@RequestMapping("/video") 
public class VideoController {    
    @Autowired
    VideoService videoService;
    
    @PostMapping 
    public Video save (@RequestBody Video video){
        return videoService.save(video);
    }
    
    @DeleteMapping
    public void remove (@RequestBody Video video){
        videoService.remove(video);
    }
    
    @DeleteMapping("/{id}")
    public void removeById (@PathVariable ("id") Long id){
        videoService.removeById(id);
    }
    @GetMapping("/{id}")
    public Video loadById(@PathVariable ("id") Long id){
        return videoService.loadById(id);
    }

    @GetMapping
    public List <Video> findAll (){
       return  (List <Video>) videoService.findAll();
    }
}
