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
public class FuncionarioDao implements CrudDao <Funcionario, Long>{
 
    private  final  Connection connection = new Connection();
  
 @Override
    public Funcionario save(Funcionario funcionario) {
       connection.getSession().saveOrUpdate(funcionario); 
       connection.fecharConeccao();
       return funcionario;
    }

    @Override
    public void remove(Funcionario funcionario) {
       Object persistentInstance =  connection.getSession().load(Funcionario.class, funcionario.getId());
       connection.getSession().delete(persistentInstance); 
       connection.fecharConeccao();
    }

    @Override
    public Funcionario loadById(Long id) {
       Funcionario funcionario;
       funcionario = (Funcionario) connection.getSession().get(Funcionario.class, id);
       connection.fecharConeccao();
       return funcionario;
    }

    @Override
    public List<Funcionario> findAll() {
        Criteria criteria =  connection.getSession().createCriteria(Funcionario.class);
        List<Funcionario> funcionarioLista =  criteria.list();
        connection.fecharConeccao();
        return funcionarioLista;
    }
    
}
