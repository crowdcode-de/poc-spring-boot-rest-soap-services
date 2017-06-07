package io.crowdcode.spring.restsoap.repository;

import io.crowdcode.spring.restsoap.model.Rahmenvertrag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by idueppe on 06.06.17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class RahmenvertragRepositoryTest {

    @Autowired
    private RahmenvertragRepository rahmenvertragRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testFindByName_RV1() throws Exception {
        Rahmenvertrag found = rahmenvertragRepository.findByName("RV1");
        assertThat(found.getBetriebsstaetten(), hasSize(2));
        assertThat(found.getName(), is("RV1"));
    }

    @Test
    public void testFindByName_RV2() throws Exception {
        Rahmenvertrag found = rahmenvertragRepository.findByName("RV2");
        assertThat(found.getBetriebsstaetten(), hasSize(2));
        assertThat(found.getName(), is("RV2"));
    }
}