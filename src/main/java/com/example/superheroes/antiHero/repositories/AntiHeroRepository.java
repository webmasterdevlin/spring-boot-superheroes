package com.example.superheroes.antiHero.repositories;

import com.example.superheroes.antiHero.entities.AntiHeroEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AntiHeroRepository
  extends CrudRepository<AntiHeroEntity, UUID> {
  // @Query("")
  // custom composite repository here
}
