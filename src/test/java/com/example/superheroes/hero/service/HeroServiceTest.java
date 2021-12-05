package com.example.superheroes.hero.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import com.example.superheroes.hero.model.Hero;
import com.example.superheroes.hero.repository.HeroRepository;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroServiceTest {

    @Mock
    private HeroRepository heroRepository;

    private HeroService underTest;

    @BeforeEach
    void setUp() {
        underTest = new HeroService(heroRepository);
    }

    @Test
    void canFindAllHeroes() {
        // when
        underTest.findAllHeroes();

        // then
        verify(heroRepository).findAll();
    }

    @Test
    void canAddHero() {
        // given
        Hero hero = new Hero(
                UUID.randomUUID(),
                "Bunao",
                "Lakandula",
                "Tondo",
                "Datu of Tondo"
        );

        // when
        underTest.addHero(hero);

        // then
        ArgumentCaptor<Hero> heroArgumentCaptor = ArgumentCaptor.forClass(
                Hero.class
        );
        verify(heroRepository).save(heroArgumentCaptor.capture());
        Hero capturedHero = heroArgumentCaptor.getValue();

        assertThat(capturedHero).isEqualTo(hero);
    }
}
