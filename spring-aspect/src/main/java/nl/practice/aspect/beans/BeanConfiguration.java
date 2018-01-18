package nl.practice.aspect.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import nl.practice.jpa.entity.Jedi;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfiguration {

	@Bean
	public Jedi createJedi(){
		Jedi jedi = new Jedi("Revan");
		return jedi;
	}



}
