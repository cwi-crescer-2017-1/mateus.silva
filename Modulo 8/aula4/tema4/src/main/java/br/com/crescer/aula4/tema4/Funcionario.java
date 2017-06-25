/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.tema4;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Mateus
 */
@Entity 
public class Funcionario implements Serializable  {

   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(name = "SEQ_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO")
    @Basic (optional = false)
    @Column(name  = "ID")
    private Long id;
    
    @Basic (optional = false)
    @Column(name= "NOME")
    private String nome;
    
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
    @Column (name = "RUA")
    private String rua;
    
    @Basic (optional = false)
    @Column (name = "RG")
    private String rg;
    
    @Basic (optional = true)
    @Column (name = "EMAIL")
    private String email;
    
    @Basic (optional = true)
    @Column (name = "TELEFONE")
    private String telefone;
    
    @Basic (optional = true)
    @Column (name = "CELULAR")
    private String celular;
    
    @Basic (optional = true)
    @Column (name = "SALARIO")
    private BigDecimal salario;
    
    @Basic (optional = true)
    @Column (name = "FUNCAO")
    private String funcao;
    
    @Basic (optional = true)
    @Column (name = "CPF")
    private String cpf;
    
    @Basic (optional = true)
    @Column (name = "NASCIMENTO")
    private Date nascimento;
    
    public Funcionario (){       
    }
    
    public Funcionario (Long id, String nome, String rg){       
        this.id = id;
        this.nome= nome;
        this.rg = rg;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
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

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public String getRua() {
        return rua;
    }

    public String getRg() {
        return rg;
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

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }
    
}
