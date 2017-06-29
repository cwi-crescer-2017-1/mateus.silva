/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Services;

import br.com.crescer.aula7.tema.Entities.Locacao;
import br.com.crescer.aula7.tema.Repositories.LocacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mateus
 */
public class LocacaoService {
     @Autowired
     LocacaoRepository locacaoRepository;
           
    public Locacao save (Locacao locacao){
        return locacaoRepository.save(locacao);
    }
    
    public void remove (Locacao locacao){
      locacaoRepository.delete(locacao);
    }

     public void removeById (Long id){
        locacaoRepository.delete(id);
    }
    public Locacao loadById(Long id){
        return locacaoRepository.findOne(id);
    }

    public List <Locacao> findAll (){
       return  (List<Locacao>) locacaoRepository.findAll();
    }
}
