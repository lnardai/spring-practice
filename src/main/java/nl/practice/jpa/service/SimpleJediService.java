package nl.practice.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.repositories.JediRepository;

@Service
public class SimpleJediService {

	private  JediRepository repository;

	@Autowired
	public SimpleJediService(JediRepository repository){
		this.repository = repository;
	}

	public List<Jedi> getAnyJedi (String name) {
		return repository.findByName(name);
	}

}
