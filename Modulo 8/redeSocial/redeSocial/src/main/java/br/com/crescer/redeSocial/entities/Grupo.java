/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Mateus
 */
@Entity
public class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRUPO")
    @SequenceGenerator(name = "SEQ_GRUPO", sequenceName = "SEQ_GRUPO")
    
    @Basic (optional = false)
    @Column (name = "ID")
    private Long id;
    
    @Basic (optional = false)
    @Column (name = "NOME")
    private String nome;
    
      
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_grupo", 
            joinColumns = {
                @JoinColumn(name = "id_usuario")
            }, 
            inverseJoinColumns = {
                @JoinColumn(name = "id_grupo")
            }
    )
    private Set<Usuario> usuarios;
}