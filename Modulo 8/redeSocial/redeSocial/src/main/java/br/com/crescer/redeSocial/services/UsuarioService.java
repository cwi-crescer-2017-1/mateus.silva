/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.services;

import br.com.crescer.redeSocial.entities.Usuario;
import br.com.crescer.redeSocial.repositories.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */

@Service
public class UsuarioService {
   private  RelationshipService relationshipService;
   public UsuarioService(RelationshipService relationshipService){
       this.relationshipService = relationshipService;
   }
    @Autowired
    UsuarioRepository usuarioRepository;
               
    public Usuario save (Usuario usuario) {        
       usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }
    
    public void remove (Usuario usuario){
      usuarioRepository.delete(usuario);
    }
     
    public void removeById (Long id){
       usuarioRepository.delete(id);
    }
    public Usuario loadById(Long id){
        return usuarioRepository.findOne(id);
    }

    public List <Usuario> findAll (){
       return  (List<Usuario>) usuarioRepository.findAll();
    }
    
    public void put(Usuario usuario){
        usuarioRepository.save(usuario);
    }
//    public boolean findOneByEmail(Usuario usuario){
//        String username = usuario.getEmail();
//        Usuario user = usuarioRepository.findOneByEmail(username);
//        if (user!=null){
//            return true;
//        }
//        return false;
//    }
    
    public Usuario findOneByEmail (String username){  
        String a = username;
        Usuario ab = usuarioRepository.findOneByEmail(username);
        return ab;
    }
    
//    public List <Usuario>loadByIdRecebidaPendente(Long id){
//   
//      return   usuarioRepository.findByAmigos();
//      
//    }

    public RelationshipService getRelationshipService() {
        return relationshipService;
    }

    public void setRelationshipService(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}

