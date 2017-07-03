/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    
    public Post(){}
       
    
    @Basic (optional = true)
    @Column (name = "DATA")
    private LocalDate data;
   
    @Basic (optional = false)
    @Column (name = "CONTEUDO")
    private String conteudo;
  
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "ID_POST")
    private Set<Likes>  curtida;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "ID_USUARIO")
    private Usuario usuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }



    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Likes> getCurtida() {
        return curtida;
    }

    public void setCurtida(Set<Likes> curtida) {
        this.curtida = curtida;
    }


    


    
}
