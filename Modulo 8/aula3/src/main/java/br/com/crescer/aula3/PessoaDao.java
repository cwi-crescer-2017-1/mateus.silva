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
public interface PessoaDao {
    void insert (Pessoa p);
    void update (Pessoa p);
    void delete (Pessoa p);
}
