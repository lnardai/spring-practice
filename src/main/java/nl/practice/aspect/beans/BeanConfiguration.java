package nl.practice.aspect.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nl.practice.aspect.model.Jedi;

@Configuration
public class BeanConfiguration {

	@Bean
	public Jedi createJedi(){
		Jedi jedi = new Jedi();
		jedi.setName("Revan");
		return jedi;
	}

}
