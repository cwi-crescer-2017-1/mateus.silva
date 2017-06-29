/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.Entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import static org.hibernate.type.TypeFactory.serializable;

/**
 *
 * @author Mateus
 */
@Entity
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE")

    @Basic (optional = false)
    @Column (name = "ID")
    private Long id;
    
    @Basic (optional = false)
    @Column (name = "NOME")
    private String nome;
    
    @Basic (optional = false)
    @Column (name = "CPF")
    private String cpf;
       
    @Basic (optional = true)
    @Column (name = "RG")
    private String rg;
       
     
    @Basic (optional = true)
    @Column (name = "RUA")
    private String rua;  
     
    @Basic (optional  = true)
    @Column (name = "BAIRRO")
    private String  bairro;
    
    @Basic (optional = true)
    @Column (name = "CIDADE")
    private String cidade;
    
    @Basic (optional = true)
    @Column (name  = "NUMERO_CASA")
    private String numeroCasa;

    @Basic (optional = true)
    @Column (name = "EMAIL")
    private String email;
    
    @Basic (optional = true)
    @Column (name = "TELEFONE")
    private String telefone;
    
    @Basic (optional = false)
    @Column (name = "CELULAR")
    private String celular;
    
    @Basic (optional = true)
    @Column (name = "NASCIMENTO")
    private Date nascimento;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public Date getNascimento() {
        return nascimento;
    }
   
    
}
