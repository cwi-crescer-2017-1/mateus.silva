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
public class LocacaoDao implements CrudDao<Locacao, Long> {
    
   private  final  Connection connection= new Connection();
    @Override
    public Locacao save(Locacao locacao) {
       connection.iniciarConeccao();
       connection.getSession().save(locacao); 
       connection.fecharConeccao();
       return locacao;
    }

    @Override
    public void remove(Locacao locacao) {
       Object persistentInstance =  connection.getSession().load(Locacao.class, locacao.getId());
       connection.iniciarConeccao();
       connection.getSession().delete(persistentInstance); 
       connection.fecharConeccao();
    }

    @Override
    public Locacao loadById(Long id) {
       Locacao locacao;
       connection.iniciarConeccao();
       locacao = (Locacao) connection.getSession().get(Locacao.class, id);
       connection.fecharConeccao();
       return locacao;
    }

    @Override
    public List<Locacao> findAll() {
        connection.iniciarConeccao();
        Criteria criteria =  connection.getSession().createCriteria(Locacao.class);
        List<Locacao> locacaoLista =  criteria.list();
        connection.fecharConeccao();
        return locacaoLista;
    }
    
}
