package com.example.superheroes.villain.repository;

import com.example.superheroes.villain.model.Villain;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillainRepository extends CrudRepository<Villain, UUID> {
  // @Query("")
  // custom composite repository here
}
