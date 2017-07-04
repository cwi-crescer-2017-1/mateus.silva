/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.controllers;

import br.com.crescer.redeSocial.entities.Usuario;
import br.com.crescer.redeSocial.services.UsuarioService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/nome/{nome}")
    public List<Usuario> loadByNome(@PathVariable("nome") String nome) {
        return usuarioService.loadByNome(nome.trim());
    }

    @GetMapping("/esporte/{esporte}")
    public List<Usuario> loadByEsporte(@PathVariable("esporte") String esporte) {
        return usuarioService.loadByEsporte(esporte.trim());
    }

    @GetMapping("/{id}")
    public Usuario loadById(@PathVariable("id") Long id) {
        return usuarioService.loadById(id);
    }

    @GetMapping("/username/{username}")
    public Usuario loadByUsername(@PathVariable String username) {
        return usuarioService.findOneByEmail(username.trim());
    }

    @GetMapping("/solicitacoes/{id}")
    public List<Usuario> loadByIdRecebidaPendente(@PathVariable("id") Long id) {
        List<Usuario> users = new ArrayList<>();
        usuarioService.getRelationshipService().loadByIdRecebidaPendente(id).forEach(b -> users.add(usuarioService.loadById(b.getId_enviada())));
        return users;
    }

    @GetMapping("/amigos")
    public List<Usuario> loadAmigos() {
        return usuarioService.LoadAmigos();
    }

    @GetMapping
    public Map<String, Object> listarUsuarios(Authentication authentication) {
        User user = getLoogedUser(authentication);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", user);
        return hashMap;
    }

    private User getLoogedUser(Authentication authentication) {
        return Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
    }

    @GetMapping("/lista")
    public List<Usuario> findAll(Authentication a) {
        final User user = getLoogedUser(a);
        final List<Usuario> list = (List<Usuario>) usuarioService.findAll();
        return list.stream().filter(u -> !u.getEmail().equals(user.getUsername()))
                .collect(toList());
    }

    @PutMapping
    public void put(@RequestBody Usuario usuario) {
        usuarioService.put(usuario);
    }

}
