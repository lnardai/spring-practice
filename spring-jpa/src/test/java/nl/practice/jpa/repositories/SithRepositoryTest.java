package nl.practice.jpa.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import nl.practice.jpa.entity.Sith;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(profiles = "localtest")
public class SithRepositoryTest {

	@Autowired
	private SithRepository repository;

	@Before
	public void configRepository() {
		configDatabaseOnce();
	}

	@Test
	public void shouldOnlyContain2Sith() {
		assertEquals(20, repository.count());
	}

	@Test
	public void shouldPageSithLordsWithGivenSize(){
		Page<Sith> sith = repository.findAll(new PageRequest(1, 10));
		assertEquals(10, sith.getNumberOfElements());
		assertEquals(20, sith.getTotalElements());
	}

	@Test
	public void shouldCouldUpAllSithWithSameName(){
		assertEquals(10, repository.countByName("Darth Bane"));
	}

	private void configDatabaseOnce(){
		if(repository.count() == 0){
			for(int i=0; i<10; i++) {
				repository.save(new Sith("Darth Bane"));
				repository.save(new Sith("Darth Baras"));
			}
		}
	}


}
