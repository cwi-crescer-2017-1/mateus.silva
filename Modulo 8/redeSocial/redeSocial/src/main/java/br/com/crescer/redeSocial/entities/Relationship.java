/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author mateus.silva
 */
@Entity
public class Relationship  implements Serializable {
    
    public Relationship(){}
    public Relationship(Long r, Long e){
    this.idRecebida =r;
    this.idEnviada =e;
            }
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RELATIONSHIP")
    @SequenceGenerator(name = "SEQ_RELATIONSHIP", sequenceName = "SEQ_RELATIONSHIP")
   
    @Id
    @Basic (optional = false)
    @Column (name = "ID")
    private Long id;

    @Basic (optional = false)
    @Column (name = "SITUACAO")
    private String situacao;
   
    @Basic (optional = false)
    @Column (name = "ID_RECEBIDA")
    private Long idRecebida;
     
    @Basic (optional = false)
    @Column (name = "ID_ENVIADA")
    private Long idEnviada;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Long getId_recebida() {
        return idRecebida;
    }

    public void setId_recebida(Long idRecebida) {
        this.idRecebida = idRecebida;
    }

    public Long getId_enviada() {
        return idEnviada;
    }

    public void setId_enviada(Long idEnviada) {
        this.idEnviada = idEnviada;
    }
    
    
    
}
