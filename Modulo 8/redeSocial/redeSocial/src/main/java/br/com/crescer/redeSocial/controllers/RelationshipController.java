/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.controllers;

import br.com.crescer.redeSocial.entities.Relationship;
import br.com.crescer.redeSocial.entities.Usuario;
import br.com.crescer.redeSocial.repositories.UsuarioRepository;
import br.com.crescer.redeSocial.services.RelationshipService;
import br.com.crescer.redeSocial.services.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mateus
 */
@RestController
@RequestMapping("/relationship")
public class RelationshipController {
   @Autowired
   RelationshipService relationshipService;
   
   
   @GetMapping ("/{id}")
   public List <Relationship> loadByIdRecebidaPendente (@PathVariable("id") Long id){
      return   relationshipService.loadByIdRecebidaPendente(id);          
   }   
   
   @PostMapping ("/aceitar/{idRecebida}/{idEnviada}")
   public void  aceitarAmizade (@PathVariable("idRecebida")Long idRecebida,  @PathVariable ( "idEnviada")  Long idEnviada){
         relationshipService.aceitarAmizade(idRecebida, idEnviada);          
   }   
}

