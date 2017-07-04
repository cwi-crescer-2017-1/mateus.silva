/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.services;

import br.com.crescer.redeSocial.entities.Likes;
import br.com.crescer.redeSocial.repositories.LikesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class LikesService {

    @Autowired
    LikesRepository likesRepository;

    public Likes save(Likes like) {
        return likesRepository.save(like);
    }

    public List<Likes> findAll() {
        return (List<Likes>) likesRepository.findAll();
    }

    public void remove(Long id) {
        likesRepository.delete(id);
    }
}
