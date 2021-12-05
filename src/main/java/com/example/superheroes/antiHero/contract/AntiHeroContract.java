package com.example.superheroes.antiHero.contract;

import com.example.superheroes.antiHero.entity.AntiHeroEntity;

import java.util.UUID;

public interface AntiHeroContract {
    Iterable<AntiHeroEntity> findAllAntiHeroes();

    AntiHeroEntity findAntiHeroById(UUID id);

    void removeAntiHeroById(UUID id);

    AntiHeroEntity addAntiHero(AntiHeroEntity antiHero);

    void updateAntiHero(UUID id, AntiHeroEntity antiHero);
}
