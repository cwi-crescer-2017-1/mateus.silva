/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.controllers;

import br.com.crescer.redeSocial.entities.Post;
import br.com.crescer.redeSocial.entities.Usuario;
import br.com.crescer.redeSocial.services.PostService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Mateus
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

//    @GetMapping ("/{page}")
//    public Page <Post> findAllByDataOrderByIdAsc(@PathVariable ("page")int page) {
//       return   postService.findAllByDataOrderByIdAsc((page, 10));
//    }
    @PostMapping
    public Post save(@RequestBody Post post) {
        return postService.save(post);
    }

    @DeleteMapping
    public void remove(@RequestBody Post post) {
        postService.remove(post);
    }

    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("{idUsuario}")
    public List<Post> findAllByUsuario(@PathVariable("idUsuario") Long idUsuario) {
        Usuario user = new Usuario();
        user.setId(idUsuario);
        return postService.findAllByUsuario(user);
    }

}
