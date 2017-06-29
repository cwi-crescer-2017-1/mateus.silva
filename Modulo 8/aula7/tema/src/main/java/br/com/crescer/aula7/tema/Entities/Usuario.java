/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author mateus.silva
 */
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO")
    @Basic (optional = false)
    @Column (name = "ID")
    private Long id;
    
    
    @ManyToMany
    @JoinTable(name = "Relationship", 
            joinColumns = {
                @JoinColumn(name = "idEnviada")
            }, 
            inverseJoinColumns = {
                @JoinColumn(name = "id_Recebida")
            }
    )
    private Set<Usuario> amigos;
    
    
    
    
}
