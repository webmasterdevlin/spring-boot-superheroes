package com.example.superheroes.hero.service;

import com.example.superheroes.hero.model.Hero;
import com.example.superheroes.hero.repository.HeroRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

  private final HeroRepository heroRepository;

  @Autowired
  public HeroService(HeroRepository heroRepository) {
    this.heroRepository = heroRepository;
  }

  public List<Hero> findAllHeroes() {
    return heroRepository.findAll();
  }

  public Optional<Hero> findHeroById(UUID id) {
    findOrThrow(id);
    return heroRepository.findById(id);
  }

  public void removeHeroById(UUID id) {
    findOrThrow(id);
    heroRepository.deleteById(id);
  }

  public Hero addHero(Hero hero) {
    return heroRepository.save(hero);
  }

  public void updateHero(UUID id, Hero hero) {
    findOrThrow(id);
    heroRepository.save(hero);
  }

  private void findOrThrow(final UUID id) {
    heroRepository
      .findById(id)
      .orElseThrow(
        () -> new IllegalArgumentException("There is no hero with the ID " + id)
      );
  }
}
