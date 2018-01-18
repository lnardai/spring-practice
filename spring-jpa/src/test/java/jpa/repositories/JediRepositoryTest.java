package jpa.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import nl.practice.jpa.repositories.JediRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JediRepositoryTest {

	@Autowired
	private JediRepository repository;

	@Test
	void tryout() {
		assertNotNull(repository);
	}
}
