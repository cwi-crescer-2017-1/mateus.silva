/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Controllers;

import br.com.crescer.aula7.tema.Entities.Genero;
import br.com.crescer.aula7.tema.Services.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/genero")
public class GeneroController {
    
    @Autowired
    GeneroService generoService;
    
    @PostMapping 
    public Genero save (@RequestBody Genero genero){
        return generoService.save(genero);
    }
    
    @DeleteMapping
    public void remove (@RequestBody Genero genero){
        generoService.remove(genero);
    }
    
    @DeleteMapping("/{id}")
    public void removeById (@PathVariable ("id") Long id){
        generoService.removeById(id);
    }
    @GetMapping("/{id}")
    public Genero loadById(@PathVariable ("id") Long id){
        return generoService.loadById(id);
    }

    @GetMapping
    public List <Genero> findAll (){
       return  (List<Genero>) generoService.findAll();
    }
    
    @PutMapping
    public void put (@RequestBody Genero genero){
       generoService.put(genero);
    }
}
