/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Controllers;

import br.com.crescer.aula7.tema.Entities.Funcionario;
import br.com.crescer.aula7.tema.Services.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mateus
 */
@RequestMapping("/funcionario")   
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;
    
    @PostMapping 
    public Funcionario save (@RequestBody Funcionario  funcionario){
        return funcionarioService.save(funcionario);
    }
    
    @DeleteMapping
    public void remove (@RequestBody Funcionario funcionario){
        funcionarioService.remove(funcionario);
    }
    
    @DeleteMapping("/{id}")
    public void removeById (@PathVariable ("id") Long id){
        funcionarioService.removeById(id);
    }
    @GetMapping("/{id}")
    public Funcionario loadById(@PathVariable ("id") Long id){
        return funcionarioService.loadById(id);
    }

    @GetMapping
    public List <Funcionario> findAll (){
       return  (List <Funcionario>) funcionarioService.findAll();
    }
}
