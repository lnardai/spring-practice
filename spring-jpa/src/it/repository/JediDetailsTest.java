package repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import nl.practice.jpa.App;
import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.entity.JediDetails;
import nl.practice.jpa.repositories.JediDetailsRepository;
import nl.practice.jpa.repositories.JediRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(profiles = "localtest")
@SpringBootTest(classes = App.class)
public class JediDetailsTest {

    private Date testStart = new Date();

    @Autowired
    private JediRepository repository;

    @Autowired
    private JediDetailsRepository detailsRepository;

    @Before
    public void name() {
        if(repository.count() == 0){
            Jedi jedi1 = new Jedi("Obi Wan Kenobi");
            JediDetails jediDetails1 = new JediDetails();
            jediDetails1.setJedi(jedi1);
            jedi1.setDetails(jediDetails1);
            repository.save(jedi1);
        }
    }

    @Test
    public void shouldFindJediWithCorrectId() throws Exception {
        Jedi result = repository.findById(1L).orElseThrow(() -> new Exception("Not found Jedi With Id"));
        assertNotNull(result.getDetails().getCreatedOn());
        assertEquals("Obi Wan Kenobi", result.getName());
    }


    @Test
    public void shouldAlsoPersistDetails() throws Exception {
        JediDetails result = detailsRepository.findById(2L).orElseThrow(() -> new Exception("Not found JediDetails With Id"));
        assertTrue( testStart.getTime() < result.getCreatedOn().getTime());
//        assertEquals("Obi Wan Kenobi", result.getJedi().getName());
    }
}
