package br.com.crescer.aula7.tema.services;

import br.com.crescer.aula7.tema.Entities.Genero;
import br.com.crescer.aula7.tema.Repositories.GeneroRepository;
import static java.util.stream.Collectors.toList;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
public class GeneroServiceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private GeneroRepository generoRepository;

    @Test
    public void testSave() {
        final Genero genero = new Genero();
        genero.setDescricao("Drama");
        generoRepository.save(genero);
        assertEquals(genero.getDescricao(), testEntityManager.find(Genero.class, genero.getId()).getDescricao());
    }

    @Test
    public void testFindAll() {
        final Genero genero = new Genero();
        genero.setDescricao("Acao");
        testEntityManager.persist(genero);

        assertTrue(StreamSupport.stream(generoRepository.findAll().spliterator(), false)
                .map(Genero::getDescricao)
                .collect(toList())
                .contains(genero.getDescricao()));
    }

    @Test
    public void testFindOne() {
        final Genero genero = new Genero();
        genero.setDescricao("Acao");
        testEntityManager.persist(genero);
        assertEquals(genero.getDescricao(), generoRepository.findOne(genero.getId()).getDescricao());
    }

    @Test
    public void testRemoveById() {
        final Genero genero = new Genero();
        genero.setDescricao("Acao");
        genero.setId(1l);
        final Genero genero1 = new Genero();
        genero1.setDescricao("Drama");
        genero1.setId(2l);
        generoRepository.save(genero);
        generoRepository.save(genero1);
        generoRepository.delete(genero);
        assertNull(generoRepository.findOne(1l));
    }

}
