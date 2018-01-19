package nl.practice.jpa.conf;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.repositories.JediRepository;

@Configuration
@Profile("production")
public class DatabaseConfig {

	@Autowired
	private JediRepository repository;

	@PostConstruct
	public void configureDatabase () {
		repository.save(new Jedi("Jack"));
		repository.save(new Jedi("Chloe"));
		repository.save(new Jedi("Kim"));
		repository.save(new Jedi("David"));
		repository.save(new Jedi("Michelle"));
		repository.save(new Jedi("Laci"));
	}
}
