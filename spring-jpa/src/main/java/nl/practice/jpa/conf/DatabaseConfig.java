package nl.practice.jpa.conf;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.entity.Sith;
import nl.practice.jpa.repositories.JediRepository;
import nl.practice.jpa.repositories.SithRepository;

@Configuration
@Profile("production")
public class DatabaseConfig {

	@Autowired
	private JediRepository jediRepository;
	@Autowired
	private SithRepository sithRepository;

	@PostConstruct
	public void configureDatabase () {
		configureJedi();
		configureSith();
	}

	private void configureJedi(){
		jediRepository.save(new Jedi("Qui-Gon Jinn"));
		jediRepository.save(new Jedi("Obi-Wan Kenobi"));
		jediRepository.save(new Jedi("Anakin Skywalker"));
		jediRepository.save(new Jedi("Quinlan Vos"));
		jediRepository.save(new Jedi("Yoda"));
		jediRepository.save(new Jedi("Mace Windu"));
		jediRepository.save(new Jedi("Shaak Ti"));
	}

	private void configureSith(){
		sithRepository.save(new Sith("Darth Andeddu"));
		sithRepository.save(new Sith("Darth Bane"));
		sithRepository.save(new Sith("Darth Baras"));
		sithRepository.save(new Sith("Darth Caedus"));
		sithRepository.save(new Sith("Darth Krayt"));
		sithRepository.save(new Sith("Darth Malak"));
		sithRepository.save(new Sith("Darth Malgus"));
	}

}
