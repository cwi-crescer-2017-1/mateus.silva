/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.entities.repositories;

import br.com.crescer.redeSocial.entities.Grupo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mateus
 */
public interface GrupoRepository extends CrudRepository <Grupo, Long> {
    
}
