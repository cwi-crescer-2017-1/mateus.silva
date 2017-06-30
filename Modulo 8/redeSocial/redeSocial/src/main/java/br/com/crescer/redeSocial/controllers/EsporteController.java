/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.controllers;

import br.com.crescer.redeSocial.entities.Esporte;
import br.com.crescer.redeSocial.services.EsporteService;
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
@RequestMapping("/esporte") 
public class EsporteController {
    
    @Autowired
    EsporteService esporteService;
    
    @PostMapping 
    public Esporte save (@RequestBody Esporte esporte){
        return esporteService.save(esporte);
    }
    
    @DeleteMapping
    public void remove (@RequestBody Esporte esporte){
        esporteService.remove(esporte);
    }
    
    @DeleteMapping("/{id}")
    public void removeById (@PathVariable ("id") Long id){
        esporteService.removeById(id);
    }
    @GetMapping("/{id}")
    public Esporte loadById(@PathVariable ("id") Long id){
        return esporteService.loadById(id);
    }

    @GetMapping
    public List <Esporte> findAll (){
       return  (List <Esporte>) esporteService.findAll();
    }
    
    @PutMapping
    public void put (@RequestBody Esporte esporte){
       esporteService.put(esporte);
    }
}

