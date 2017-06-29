/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author mateus.silva
 */
@Service
public class GeneroService   {
   
   @Autowired
   GeneroRepository generoRespository;
    
     public Genero getGenero(Long id) {
      return generoRespository.findOne(id);
     }
     
     public void deleteGenero(Long id) {
      generoRespository.delete(id);
     }
     
     
}
