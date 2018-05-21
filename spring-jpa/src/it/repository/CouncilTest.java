package repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import nl.practice.jpa.App;
import nl.practice.jpa.entity.Council;
import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.entity.JediDetails;
import nl.practice.jpa.repositories.CouncilRepository;
import nl.practice.jpa.repositories.JediRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ActiveProfiles(profiles = "localtest")
@SpringBootTest(classes = App.class)
public class CouncilTest {
        private Date testStart = new Date();

        @Autowired
        private JediRepository jediRepository;

        @Autowired
        private CouncilRepository councilRepository;

        @Before
        public void name() {
            if(jediRepository.count() == 0){
                Jedi jedi1 = new Jedi("Obi Wan Kenobi");
                Jedi jedi2 = new Jedi("Anakin Skywalker");
                JediDetails jediDetails1 = new JediDetails();
                jediDetails1.setJedi(jedi1);
                jedi1.setDetails(jediDetails1);
                Council council =new Council();
                council.addOne(jedi1);
                council.addOne(jedi2);
                jediRepository.save(jedi1);
                councilRepository.save(council);
            }
        }

        @Test
        public void shouldFindJediWithCorrectId() throws Exception {
            Council result = councilRepository.findById(1L).orElseThrow(() -> new Exception("Not found council With Id"));
            Set<Jedi> members =  result.getMembers();
            assertEquals(2, members.size());
            assertEquals("Anakin Skywalker", members.iterator().next().getName());
        }
}
