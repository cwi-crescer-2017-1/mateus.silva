/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Services;

import br.com.crescer.aula7.tema.Entities.Cliente;
import br.com.crescer.aula7.tema.Repositories.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mateus
 */
public class ClienteService {
    @Autowired
     ClienteRepository clienteRepository;
           
    public Cliente save (Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    public void remove (Cliente cliente){
      clienteRepository.delete(cliente);
    }

     public void removeById (Long id){
        clienteRepository.delete(id);
    }
    public Cliente loadById(Long id){
        return clienteRepository.findOne(id);
    }

    public List <Cliente> findAll (){
       return  (List<Cliente>) clienteRepository.findAll();
    }
}
