/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.controllers;

import br.com.crescer.redeSocial.entities.Likes;
import br.com.crescer.redeSocial.services.LikesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mateus
 */
@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    LikesService likesService;

    @PostMapping
    public Likes save(@RequestBody Likes like) {
        return likesService.save(like);
    }

    @GetMapping
    public List<Likes> findAll() {
        return (List<Likes>) likesService.findAll();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        likesService.remove(id);
    }
}
