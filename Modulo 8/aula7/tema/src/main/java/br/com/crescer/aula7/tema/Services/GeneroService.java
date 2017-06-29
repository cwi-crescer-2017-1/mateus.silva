/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Services;

import br.com.crescer.aula7.tema.Entities.Genero;
import br.com.crescer.aula7.tema.Repositories.GeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class GeneroService {
   @Autowired 
   GeneroRepository generoRepository;
           
    public Genero save (Genero genero){
        return generoRepository.save(genero);
    }
    
    public void remove (Genero genero){
        generoRepository.delete(genero);
    }

     public void removeById (Long id){
        generoRepository.delete(id);
    }
    public Genero loadById(Long id){
        return generoRepository.findOne(id);
    }

    public List <Genero> findAll (){
       return  (List<Genero>) generoRepository.findAll();
    }
     public void put(Genero genero){
        generoRepository.save(genero);
    }
}
