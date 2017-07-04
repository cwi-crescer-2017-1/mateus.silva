/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.repositories;

import br.com.crescer.redeSocial.entities.Post;
import br.com.crescer.redeSocial.entities.Usuario;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mateus
 */
public interface PostRepository extends CrudRepository <Post, Long> {
    public List <Post> findByUsuario(Usuario idUsuario);
//    public Page <Post> findAllByDataOrderByIdDesc(Pageable pageable);
}
