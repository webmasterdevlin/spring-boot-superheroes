package com.example.superheroes.hero.controller;

import com.example.superheroes.hero.model.Hero;
import com.example.superheroes.hero.service.HeroService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Heroes", produces = "application/json", tags = "hero")
@RestController
@RequestMapping(path = "api/v1/heroes")
public class HeroController {

  private final HeroService heroService;

  public HeroController(HeroService heroService) {
    this.heroService = heroService;
  }

  @GetMapping
  public ResponseEntity<List<Hero>> getHeroes() {
    var heroes = heroService.findAllHeroes();
    return new ResponseEntity<>(heroes, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Hero>> getHeroById(
    @PathVariable("id") Long id
  ) {
    var hero = heroService.findHeroById(id);
    return new ResponseEntity<>(hero, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteHeroById(@PathVariable("id") Long id) {
    heroService.removeHeroById(id);
    return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity<Hero> postHero(@Valid @RequestBody Hero hero) {
    var createdHero = heroService.addHero(hero);
    return new ResponseEntity<>(createdHero, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> putHero(
    @PathVariable("id") Long id,
    @Valid @RequestBody Hero hero
  ) {
    heroService.updateHero(id, hero);
    return new ResponseEntity<>(null, HttpStatus.OK);
  }
}
