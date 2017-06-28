/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mateus.silva
 */
@RestController
public class GeneroController {
    
    @Autowired
 //  GeneroRepository generoRespository;
    GeneroService generoService;
    
    @RequestMapping(value = "/genero/{id}", method = RequestMethod.GET)
     public Genero getGenero(@PathVariable Long id){
     return generoService.getGenero(id);
     
     }
     
     @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
     public void deleteGenero(@PathVariable Long id){
     generoService.deleteGenero(id);
     
     }

}