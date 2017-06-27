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
public class ClienteDao implements CrudDao<Cliente,Long>{
    
    private  final  Connection connection = new Connection();

    @Override
    public Cliente save(Cliente cliente) {
       connection.getSession().saveOrUpdate(cliente); 
       connection.fecharConeccao();
       return cliente;  
    }

    @Override
    public void remove(Cliente cliente) {
       Object persistentInstance =  connection.getSession().load(Cliente.class, cliente.getId());
       connection.getSession().delete(persistentInstance); 
       connection.fecharConeccao();
    }

    @Override
    public Cliente loadById(Long id) {
       Cliente cliente;
       cliente = (Cliente)  connection.getSession().get(Cliente.class, id);
       connection.fecharConeccao();
       return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        Criteria criteria =  connection.getSession().createCriteria(Cliente.class);
        List<Cliente> clienteLista =  criteria.list();
        connection.fecharConeccao();
        return clienteLista; 
    }      
}