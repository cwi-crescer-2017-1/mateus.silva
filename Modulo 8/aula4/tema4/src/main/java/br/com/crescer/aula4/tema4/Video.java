/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.tema4;

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

/**
 *
 * @author Mateus
 */
@Entity
public class Video {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VIDEO")
    @Basic (optional = false)
    @Column (name = "ID_VIDEO")
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
      
      
}