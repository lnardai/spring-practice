package nl.practice.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.practice.jpa.entity.EntityNotFoundException;
import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.repositories.JediRepository;

@Service
public class SimpleJediService {

	@Autowired
	private  JediRepository repository;

	@Autowired
	public SimpleJediService(JediRepository repository){
		this.repository = repository;
	}

	public List<Jedi> getAnyJedi (String name) {
		return repository.findByName(name);
	}

	public Jedi getExactJedi(long id){
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("JediId:" +id));
	}

}
