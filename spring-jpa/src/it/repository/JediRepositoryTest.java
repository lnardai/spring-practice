package repository;

import static org.junit.Assert.assertEquals;

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
import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.repositories.JediRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ActiveProfiles(profiles = "localtest")
@SpringBootTest(classes = App.class)
public class JediRepositoryTest {

	@Autowired
	private JediRepository repository;

	@Before
	public void name() {
		if(repository.count() == 0){
			repository.save(new Jedi("Obi Wan Kenobi"));
			repository.save(new Jedi("Mace Windu"));
		}
	}

	@Test
	public void shouldOnlyContain2Jedi() {
		assertEquals(repository.count(), 2);
	}

	@Test
	public void shouldFindJediWithCorrectId() throws Exception {
		Jedi result = repository.findById(1L).orElseThrow(() -> new Exception("Not found Jedi With Id"));
		assertEquals("Obi Wan Kenobi", result.getName());
	}
}
