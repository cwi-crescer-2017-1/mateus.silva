/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.services;

import br.com.crescer.redeSocial.entities.Esporte;
import br.com.crescer.redeSocial.repositories.EsporteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class EsporteService {
    @Autowired
    EsporteRepository esporteRepository;
               
    public Esporte save (Esporte esporte){
        return esporteRepository.save(esporte);
    }
   
    public void remove (Esporte esporte){
      esporteRepository.delete(esporte);
    }
     
    public void removeById (Long id){
       esporteRepository.delete(id);
    }
    public Esporte loadById(Long id){
        return esporteRepository.findOne(id);
    }

    public List <Esporte> findAll (){
       return  (List<Esporte>) esporteRepository.findAll();
    }
    
    public void put(Esporte esporte){
        esporteRepository.save(esporte);
    }
}

