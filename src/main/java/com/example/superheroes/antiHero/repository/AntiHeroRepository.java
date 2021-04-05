package com.example.superheroes.antiHero.repository;

import com.example.superheroes.antiHero.entity.AntiHeroEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AntiHeroRepository
  extends CrudRepository<AntiHeroEntity, UUID> {
  // @Query("")
  // custom composite repository here
}
