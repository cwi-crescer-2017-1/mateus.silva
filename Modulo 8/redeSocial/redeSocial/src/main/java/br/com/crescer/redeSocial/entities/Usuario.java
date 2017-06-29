/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.entities;
import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    @Basic (optional = false)
    @Column (name = "RG")
    private String rg;
     
    @Basic (optional = false)
    @Column (name = "EMAIL")
    private String email;
    
    @Basic (optional =true)
    @Column (name = "CELULAR")
    private String celular;
     
    @Basic (optional = true)
    @Column (name = "TELEFONE")
    private String telefone;
    
    @Basic (optional = false)
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
    
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_grupo", 
            joinColumns = {
                @JoinColumn(name = "id_usuario")
            }, 
            inverseJoinColumns = {
                @JoinColumn(name = "id_grupo")
            }
    )
    private Set<Grupo> grupos;
    
  
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
