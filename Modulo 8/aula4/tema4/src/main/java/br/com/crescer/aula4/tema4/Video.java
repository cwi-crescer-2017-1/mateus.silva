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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Mateus
 */ 
@Entity
public class Video implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO")
    @Basic (optional = false)
    @Column (name = "ID")
    private Long id;
    
    @Basic (optional = false)
    @Column (name = "VALOR")
    private BigDecimal valor;
    
    @Basic (optional = true)
    @Column (name = "DURACAO")
    private String duracao;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "ID_GENERO")
    private Genero genero;
         
    @Basic (optional = true)
    @Column (name = "NOME")
    private String nome;
    
    @Basic (optional = true)
    @Column (name = "QUANTIDADE_ESTOQUE")
    private int  quantidadeEstoque;
    
    @Basic (optional = true)
    @Column (name = "DATA_LANCAMENTO")
    private Date  dataLancamento;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public Genero getGenero() {
        return genero;
    }
     
    
    
      
}