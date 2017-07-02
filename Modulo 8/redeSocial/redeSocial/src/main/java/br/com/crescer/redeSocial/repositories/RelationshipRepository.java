/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.repositories;

import br.com.crescer.redeSocial.entities.Relationship;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mateus
 */
public interface RelationshipRepository extends CrudRepository <Relationship, Long> {
    public List <Relationship> findByIdRecebida(Long id);
    public List <Relationship> findAllBySituacao(String situacao);
     public List <Relationship> findBySituacaoAndIdRecebida(String situacao, Long id);
     public Relationship findByIdRecebidaAndIdEnviada (Long IdRecebida, Long idEnviada);
}
