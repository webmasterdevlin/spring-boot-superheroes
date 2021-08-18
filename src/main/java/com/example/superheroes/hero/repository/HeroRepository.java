package com.example.superheroes.hero.repository;

import com.example.superheroes.hero.model.Hero;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface HeroRepository extends JpaRepository<Hero, UUID> {
  // @Query("")
  // custom composite repository here
}
