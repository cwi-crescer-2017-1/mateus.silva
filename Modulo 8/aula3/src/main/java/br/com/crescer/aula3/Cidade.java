/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

/**
 *
 * @author Mateus
 */
public class Cidade {
    private Long id;
    private String nome;
    private Long estado;

    public Long getEstado() {
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
