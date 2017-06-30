/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.controllers;

import br.com.crescer.redeSocial.entities.Usuario;
import br.com.crescer.redeSocial.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario)  {
       return usuarioService.save(usuario);   
    }

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

    @GetMapping
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioService.findAll();
    }

    @PutMapping
    public void put(@RequestBody Usuario usuario) {
        usuarioService.put(usuario);
    }
}
