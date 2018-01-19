package nl.practice.jpa.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.practice.jpa.entity.Sith;

@Repository
public interface SithRepository extends JpaRepository<Sith, Long> {

    List<Sith> findByName(String lastName);

    Page<Sith> findAll(Pageable pageable);
}