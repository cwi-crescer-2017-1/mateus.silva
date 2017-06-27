/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.tema4;

import java.util.List;
import org.hibernate.Criteria;


/**
 *
 * @author Mateus
 */
public class GeneroDao implements CrudDao <Genero, Long> {
    
    private  final  Connection connection= new Connection();
    @Override
    public Genero save(Genero genero) {
       connection.iniciarConeccao();
       connection.getSession().saveOrUpdate(genero); 
       connection.fecharConeccao();
       return genero;
    }

    @Override
    public void remove(Genero genero) {
       Object persistentInstance =  connection.getSession().load(Genero.class, genero.getId());
       connection.iniciarConeccao();
       connection.getSession().delete(persistentInstance); 
       connection.fecharConeccao();
    }

    @Override
    public Genero loadById(Long id) {
       Genero genero;
       connection.iniciarConeccao();
       genero = (Genero) connection.getSession().get(Genero.class, id);
       connection.fecharConeccao();
       return genero;
    }

    @Override
    public List<Genero> findAll() {
        connection.iniciarConeccao();
        Criteria criteria =  connection.getSession().createCriteria(Genero.class);
        List<Genero> generoLista =  criteria.list();
        connection.fecharConeccao();
        return generoLista;
    }
    
}
