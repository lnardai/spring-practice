package nl.practice.jpa.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.practice.jpa.entity.JediDetails;

@Repository
public interface JediDetailsRepository extends JpaRepository<JediDetails, Long> {

    Optional<JediDetails> findById(long id);

}
