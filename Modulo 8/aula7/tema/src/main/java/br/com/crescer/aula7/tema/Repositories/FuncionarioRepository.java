/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Repositories;

import br.com.crescer.aula7.tema.Entities.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mateus
 */
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{
    
}
