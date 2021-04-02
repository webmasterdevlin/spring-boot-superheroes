package com.example.superheroes.hero.repository;

import com.example.superheroes.hero.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
  // @Query("")
  // custom composite repository here
}
