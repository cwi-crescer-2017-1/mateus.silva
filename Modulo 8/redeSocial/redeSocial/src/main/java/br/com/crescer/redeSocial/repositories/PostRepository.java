/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.repositories;

import br.com.crescer.redeSocial.entities.Post;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mateus
 */
public interface PostRepository extends CrudRepository <Post, Long> {
    
}
