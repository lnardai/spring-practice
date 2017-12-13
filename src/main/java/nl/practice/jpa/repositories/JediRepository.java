package nl.practice.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nl.practice.jpa.entity.Jedi;

public interface JediRepository extends CrudRepository<Jedi, Long> {

    List<Jedi> findByName(String lastName);
}