package nl.practice.jpa.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import nl.practice.jpa.entity.Jedi;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(profiles = "localtest")
public class JediRepositoryTest {

	@Autowired
	private JediRepository repository;

	@Test
	public void shouldOnlyContain2Jedi() {
		repository.save(new Jedi("Obi Wan Kenobi"));
		repository.save(new Jedi("Mace Windu"));
		assertEquals(repository.count(), 2);
	}
}
