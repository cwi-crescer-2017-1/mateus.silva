/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Controllers;

import br.com.crescer.aula7.tema.Entities.Cliente;
import br.com.crescer.aula7.tema.Services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mateus
 */
@RequestMapping("/cliente")   
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    
    @PostMapping 
    public Cliente save (@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }
    
    @DeleteMapping
    public void remove (@RequestBody Cliente cliente){
        clienteService.remove(cliente);
    }
    
    @DeleteMapping("/{id}")
    public void removeById (@PathVariable ("id") Long id){
        clienteService.removeById(id);
    }
    @GetMapping("/{id}")
    public Cliente loadById(@PathVariable ("id") Long id){
        return clienteService.loadById(id);
    }

    @GetMapping
    public List <Cliente> findAll (){
       return  (List <Cliente>) clienteService.findAll();
    }
}
