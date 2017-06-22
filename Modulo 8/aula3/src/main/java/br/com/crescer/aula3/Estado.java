/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

/**
 *
 * @author mateus.silva
 */
public class Estado {
    private Long id;
    private String nome;
    private String uf;
    private Pais pais;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public String getUf() {
        return uf;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
}
