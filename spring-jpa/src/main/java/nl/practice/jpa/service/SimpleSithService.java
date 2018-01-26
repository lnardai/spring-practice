package nl.practice.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.entity.Sith;
import nl.practice.jpa.repositories.JediRepository;
import nl.practice.jpa.repositories.SithRepository;

@Service
public class SimpleSithService {

	@Autowired
	private  SithRepository repository;

	@Autowired
	public SimpleSithService(SithRepository repository){
		this.repository = repository;
	}

	public List<Sith> getAnySith(String name) {
		return repository.findByName(name);
	}

	public boolean isNameContainsDarth(String name) {
		return name.contains("Darth");
	}

}
