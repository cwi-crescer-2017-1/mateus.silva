/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Controllers;

import br.com.crescer.aula7.tema.Entities.Locacao;
import br.com.crescer.aula7.tema.Services.LocacaoService;
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
@RequestMapping("/locacao") 
public class LocacaoController {
    @Autowired
    LocacaoService locacaoService;
    
    @PostMapping 
    public Locacao save (@RequestBody Locacao  locacao){
        return locacaoService.save(locacao);
    }
    
    @DeleteMapping
    public void remove (@RequestBody Locacao  locacao){
        locacaoService.remove(locacao);
    }
    
    @DeleteMapping("/{id}")
    public void removeById (@PathVariable ("id") Long id){
        locacaoService.removeById(id);
    }
    @GetMapping("/{id}")
    public Locacao loadById(@PathVariable ("id") Long id){
        return locacaoService.loadById(id);
    }

    @GetMapping
    public List <Locacao> findAll (){
       return  (List <Locacao>) locacaoService.findAll();
    }
}
