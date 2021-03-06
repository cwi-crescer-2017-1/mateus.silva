/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.controllers;

import br.com.crescer.redeSocial.entities.Usuario;
import br.com.crescer.redeSocial.services.UsuarioService;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import javax.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mateus
 */
@RestController
@RequestMapping("/acessos")
public class AcessoController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) throws Exception {
        if (usuarioService.findByEmailIgnoreCase(usuario.getEmail()) != null) {
            throw new Exception("Usuário com email já cadastrado");
        }
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new Exception("Informe o nome");
        }
        if (usuario.getSobrenome() == null || usuario.getSobrenome().isEmpty()) {
            throw new Exception("Informe o sobrenome");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new Exception("Informe a senha");
        }
        if (usuario.getGenero() == null || usuario.getGenero().isEmpty()) {
            throw new Exception("Informe seu gênero");
        }
        if (usuario.getDataNascimento() == null) {
            throw new Exception("Informe a data de nascimento");
        }
        if (usuario.getEsporte() == null) {
            throw new Exception("Selecine um esporte");
        }
        return usuarioService.save(usuario);
    }

}
