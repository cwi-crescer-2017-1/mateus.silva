package br.com.crescer.aula7.tema.services;
import br.com.crescer.aula7.tema.Entities.Locacao;
import br.com.crescer.aula7.tema.Repositories.LocacaoRepository;
import java.math.BigDecimal;
import static java.util.stream.Collectors.toList;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@ContextConfiguration
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.REQUIRED)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LocacaoServiceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private LocacaoRepository locacaoRespository;

  
    @Test
    public void testSave() {
        final Locacao locacao  = new Locacao();
        locacao.setValorTotal(new BigDecimal(323));
        locacaoRespository.save(locacao);
        assertEquals(locacao.getValorTotal(), testEntityManager.find(Locacao.class, locacao.getId()).getValorTotal());
    }


    @Test
    public void testFindAll() {
        final Locacao  locacao = new Locacao();
        locacao.setValorTotal(new BigDecimal(323));
        testEntityManager.persist(locacao);

        assertTrue(StreamSupport.stream(locacaoRespository.findAll().spliterator(), false)
                .map(Locacao::getValorTotal)
                .collect(toList())
                .contains(locacao.getValorTotal()));
    }


    @Test
    public void testFindOne() {
        final Locacao locacao = new Locacao();
        locacao.setValorTotal(new BigDecimal(323));
        testEntityManager.persist(locacao);
        assertEquals(locacao.getValorTotal(), locacaoRespository.findOne(locacao.getId()).getValorTotal());
    }
    
//      @Test
//    public void testRemoveById() {
//        final Genero genero = new Genero();
//        genero.setDescricao("Acao");
//        genero.setId(1l);
//         final Genero genero1 = new Genero();
//        genero1.setDescricao("Drama");
//        genero1.setId(2l);
//          generoRespository.save(genero);
//          generoRespository.save(genero1);
//        generoRespository.delete(1l);
//           assertNull(StreamSupport.stream(generoRespository.findAll().spliterator(), false)
//                .map(Genero::getDescricao)
//                .collect(toList())
//                .contains(genero.getDescricao()));
//    }

}