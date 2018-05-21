package nl.practice.jpa.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.practice.jpa.entity.Council;

@Repository
public interface CouncilRepository extends JpaRepository<Council, Long> {

    Optional<Council> findById(long id);

}
