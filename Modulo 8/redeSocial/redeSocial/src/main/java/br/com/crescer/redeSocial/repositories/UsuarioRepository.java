/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redeSocial.repositories;

import br.com.crescer.redeSocial.entities.Relationship;
import br.com.crescer.redeSocial.entities.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mateus
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    public Usuario findOneByEmail(String string);

    public Usuario findByEmailIgnoreCase(String string);

    public List<Usuario> findByNomeIgnoreCase(String string);

    public List<Usuario> findByEsporteIgnoreCase(String string);
}
