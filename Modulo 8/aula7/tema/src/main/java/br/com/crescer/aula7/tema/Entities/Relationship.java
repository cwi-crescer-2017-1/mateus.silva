/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Entities;

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
    
    @Id
    @Basic (optional = false)
    @Column (name = "ID")
    private Long id;

    @Basic (optional = false)
    @Column (name = "SITUACAO")
    private String situacao;
    
    
}
