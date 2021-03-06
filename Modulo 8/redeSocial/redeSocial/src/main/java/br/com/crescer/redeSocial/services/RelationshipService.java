/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.services;

import br.com.crescer.redeSocial.entities.Relationship;
import br.com.crescer.redeSocial.repositories.RelationshipRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class RelationshipService {

    @Autowired
    RelationshipRepository relationshipRepository;

    public List<Relationship> loadByIdRecebidaPendente(Long id) {

        return relationshipRepository.findBySituacaoAndIdRecebida("pendente", id);

    }

    public Relationship buscarSituacao(Long idRecebida, Long idEnviada) {
        Relationship r = relationshipRepository.findByIdRecebidaAndIdEnviada(idRecebida, idEnviada);
        if (r == null) {
            return relationshipRepository.findByIdRecebidaAndIdEnviada(idEnviada, idRecebida);
        } else {
            return r;
        }
    }

    public void aceitarAmizade(Long idRecebida, Long idEnviada) {
        Relationship r = relationshipRepository.findByIdRecebidaAndIdEnviada(idRecebida, idEnviada);
        r.setSituacao("amigos");
        relationshipRepository.save(r);
    }

    public void add(Long idRecebida, Long idEnviada) {
        Relationship r = new Relationship();
        r.setId_enviada(idEnviada);
        r.setId_recebida(idRecebida);
        r.setSituacao("pendente");
        relationshipRepository.save(r);
    }

    public void rejeitarAmizade(Long idRecebida, Long idEnviada) {
        Relationship r = relationshipRepository.findByIdRecebidaAndIdEnviada(idRecebida, idEnviada);
        r.setSituacao("recusada");
        relationshipRepository.save(r);
    }

    public List<Relationship> loadAmigos(Long id) {
        List<Relationship> relacoes = relationshipRepository.findByIdRecebidaOrIdEnviada(id, id);
        List<Relationship> amigos = new ArrayList<>();

        for (Relationship r : relacoes) {
            if (r.getSituacao().compareTo("amigos") == 0) {
                amigos.add(r);
            }
        }
        return amigos;
    }

}
