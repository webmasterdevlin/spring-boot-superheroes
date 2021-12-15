package com.example.superheroes;

import com.example.superheroes.hero.model.Hero;
import com.example.superheroes.hero.repository.HeroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class DataLoader implements CommandLineRunner {

    final HeroRepository heroRepository;

    public DataLoader(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUserData();

    }

    private void loadUserData() {
        if (heroRepository.count() == 0) {
            var hero1 = new Hero(UUID.randomUUID(), "Jim", "Logan", "Marvel", "The Wolverine");
            var hero2 = new Hero(UUID.randomUUID(), "Peter", "Parker", "Marvel", "The Spider-man");
            heroRepository.save(hero1);
            heroRepository.save(hero2);
        }

        System.out.println(heroRepository.count());
    }
}