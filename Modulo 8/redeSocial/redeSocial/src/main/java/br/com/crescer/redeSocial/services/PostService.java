/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.services;

import br.com.crescer.redeSocial.entities.Post;
import br.com.crescer.redeSocial.entities.Usuario;
import br.com.crescer.redeSocial.repositories.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service 
public class PostService {
    @Autowired
    PostRepository postRepository;
            
     public Post  save (Post post){
        return postRepository.save(post);
    }
   
    public void remove (Post post){
     postRepository.delete(post);
    }
     public List <Post> findAll (){
       return  (List<Post>)postRepository.findAll();
    }
     
    public List <Post> findAllByUsuario (Usuario usuario){
       return  postRepository.findByUsuario(usuario);
    }
     
}
