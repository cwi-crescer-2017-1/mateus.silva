/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.services;

import br.com.crescer.redeSocial.entities.Usuario;
import br.com.crescer.redeSocial.repositories.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class UsuarioService {

    private RelationshipService relationshipService;
    private PostService postService;

    public UsuarioService(RelationshipService relationshipService, PostService postService) {
        this.relationshipService = relationshipService;
        this.postService = postService;
    }

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public void remove(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public void removeById(Long id) {
        usuarioRepository.delete(id);
    }

    public Usuario loadById(Long id) {
        return usuarioRepository.findOne(id);
    }

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public void put(Usuario usuario) {
        this.remove(usuario);
        this.save(usuario);
  
    }

    public Usuario findOneByEmail(String username) {
        String a = username;
        Usuario ab = usuarioRepository.findOneByEmail(username);
        return ab;
    }

    public Usuario findByEmailIgnoreCase(String email) {
        return usuarioRepository.findByEmailIgnoreCase(email);
    }

    public RelationshipService getRelationshipService() {
        return relationshipService;
    }

    public void setRelationshipService(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getUsuarioLogado() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(this::findByEmailIgnoreCase)
                .orElse(null);
    }
}
