package nl.practice.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javafx.application.Application;
import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.repositories.JediRepository;

@SpringBootApplication
@ComponentScan("nl.practice.jpa")
public class App {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner demo(JediRepository repository) {
		return (args) -> {
			// save a couple of )Jedis
			repository.save(new Jedi("Jack"));
			repository.save(new Jedi("Chloe"));
			repository.save(new Jedi("Kim"));
			repository.save(new Jedi("David"));
			repository.save(new Jedi("Michelle"));

			// fetch all Jedis
			log.info("Jedis found with findAll():");
			log.info("-------------------------------");
			for (Jedi Jedi : repository.findAll()) {
				log.info(Jedi.toString());
			}
			log.info("");

			// fetch an individual Jedi by ID
			Jedi Jedi = repository.findOne(1L);
			log.info("Jedi found with findOne(1L):");
			log.info("--------------------------------");
			log.info(Jedi.toString());
			log.info("");

			log.info("");
		};
	}

}
