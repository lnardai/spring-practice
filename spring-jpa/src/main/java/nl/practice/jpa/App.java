package nl.practice.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javafx.application.Application;
import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.repositories.JediRepository;
import nl.practice.jpa.service.SimpleJediService;

@SpringBootApplication
@ComponentScan("nl.practice.jpa")
public class App {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private SimpleJediService service;

	@Autowired
	public App(SimpleJediService service){
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner demo(JediRepository repository) {
		return (args) -> {
			// fetch all Jedis
			log.info("Jedis found with findAll():");
			log.info("-------------------------------");
			for (Jedi jedi : repository.findAll()) {
				log.info(jedi.toString());
			}
			log.info("");

			// fetch an individual Jedi by ID
			List<Jedi> jedi = service.getAnyJedi("Laci");
			log.info("Jedi found with findOne(1L):");
			log.info("--------------------------------");
			log.info(jedi.toString());
		};
	}

}
