/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.entities.repositories;

import br.com.crescer.redeSocial.entities.Esporte;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mateus
 */
public interface EsporteRepository extends CrudRepository <Esporte, Long> {
    
}
