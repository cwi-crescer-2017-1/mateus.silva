/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Mateus
 */
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO")
    
    @Basic (optional = false)
    @Column (name = "ID")
    private Long id;
    
    @Basic (optional = false)
    @Column (name = "NOME")
    private String nome;
    
    @Basic (optional = false)
    @Column (name = "SOBRENOME")
    private String sobrenome;
    
    @Basic (optional = true)
    @Column (name = "URL_FOTO")
    private String foto;
      
    @Basic (optional = true)
    @Column (name = "CIDADE")
    private String cidade;
    
    @Basic (optional = true)
    @Column (name = "RUA")
    private String rua;
    
    @Basic (optional = true)
    @Column (name = "BAIRRO")
    private String bairro;
    
    @Basic (optional = true)
    @Column (name = "NUMERO_CASA")
    private String numero_casa;
    
    @Basic (optional = true)
    @Column (name = "RG")
    private String rg;
     
    @Basic (optional = false)
    @Column (name = "EMAIL")
    private String email;
    
    @Basic (optional =true)
    @Column (name = "CELULAR")
    private String celular;
    
    @Basic (optional = true)
    @Column (name = "DATA_NASCIMENTO")
    private Date dataNascimento;
     
    @Basic (optional = false)
    @Column (name = "SENHA")
    private String senha;
    
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_esporte", 
            joinColumns = {
                @JoinColumn(name = "id_usuario")
            }, 
            inverseJoinColumns = {
                @JoinColumn(name = "id_esporte")
            }
    )
    private Set<Esporte> esportes;
     
    @ManyToMany
    @JoinTable(name = "Relationship", 
            joinColumns = {
                @JoinColumn(name = "id_Enviada")
            }, 
            inverseJoinColumns = {
                @JoinColumn(name = "id_Recebida")
            }
    )
    private Set<Usuario> amigos;
     
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "ID_LIKE")
    private Likes like;
    
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Likes getLike() {
        return like;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Esporte> getEsportes() {
        return esportes;
    }

    public void setEsportes(Set<Esporte> esportes) {
        this.esportes = esportes;
    }


    public Set<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(Set<Usuario> amigos) {
        this.amigos = amigos;
    }
    
}
