/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author mateus.silva
 */
@Entity
public class Pessoa {

    @Id // Identifica a PK
    @Basic(optional = false)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NM_PESSOA")
    private String nome;
    
 
  
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}