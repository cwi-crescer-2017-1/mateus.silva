/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Services;

import br.com.crescer.aula7.tema.Entities.Funcionario;
import br.com.crescer.aula7.tema.Repositories.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class FuncionarioService {
   @Autowired 
   FuncionarioRepository funcionarioRepository;
           
    public Funcionario save (Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
    
    public void remove (Funcionario funcionario){
       funcionarioRepository.delete(funcionario);
    }

     public void removeById (Long id){
        funcionarioRepository.delete(id);
    }
    public Funcionario loadById(Long id){
        return funcionarioRepository.findOne(id);
    }

    public List <Funcionario> findAll (){
       return  (List<Funcionario>) funcionarioRepository.findAll();
    }
    
      public void put(Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }
    
}
