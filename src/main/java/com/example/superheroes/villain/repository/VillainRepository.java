package com.example.superheroes.villain.repository;

import com.example.superheroes.villain.model.Villain;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VillainRepository extends JpaRepository<Villain, UUID> {
  // @Query("")
  // custom composite repository here
}
