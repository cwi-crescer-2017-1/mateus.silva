/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.entities;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Mateus
 */
@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POST")
    @SequenceGenerator(name = "SEQ_POST", sequenceName = "SEQ_POST")
    
     
    @Basic (optional = false)
    @Column (name = "ID")
    private Long id;

    public Post(String conteudo, Long idUsuario) {
        this.data = new Date();
        this.conteudo = conteudo;
        this.idUsuario = idUsuario;
    }
    
    public Post(){}
       
    
   @Basic (optional = true)
    @Column (name = "DATA")
    private Date data;
   
    @Basic (optional = false)
    @Column (name = "CONTEUDO")
    private String conteudo;
    
    @Basic (optional = false)
    @Column (name = "ID_USUARIO")
    private Long idUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
