/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.controllers;

import br.com.crescer.redeSocial.entities.Usuario;
import br.com.crescer.redeSocial.services.UsuarioService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mateus
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    

    
    @DeleteMapping 
    public void remove(@RequestBody Usuario usuario) {
        usuarioService.remove(usuario);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable("id") Long id) {
        usuarioService.removeById(id);
    }

    @GetMapping("/{id}")
    public Usuario loadById(@PathVariable("id") Long id) {
        return usuarioService.loadById(id);
    }
    
    @GetMapping("/username/{username}")
    public Usuario loadByUsername (@PathVariable String username) {
        return usuarioService.findOneByEmail(username.trim());
    }

 
    @GetMapping
    public Map<String, Object> listarUsuarios(Authentication authentication) {
        User u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", u);
        return hashMap;
    }
    
    @PutMapping
    public void put(@RequestBody Usuario usuario) {
        usuarioService.put(usuario);
    }
}
