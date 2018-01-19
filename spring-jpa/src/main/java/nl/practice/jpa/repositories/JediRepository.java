package nl.practice.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.practice.jpa.entity.Jedi;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    List<Jedi> findByName(String lastName);
}