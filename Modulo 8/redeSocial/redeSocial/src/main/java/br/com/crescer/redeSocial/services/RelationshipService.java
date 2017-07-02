/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.services;

import br.com.crescer.redeSocial.entities.Relationship;
import br.com.crescer.redeSocial.repositories.RelationshipRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class RelationshipService {
    @Autowired
    RelationshipRepository relationshipRepository;
               
    public List <Relationship>loadByIdRecebidaPendente(Long id){
   
      return   relationshipRepository.findBySituacaoAndIdRecebida("pendente", id);
      
    }
}
