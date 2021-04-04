package com.example.superheroes.antiHero.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import com.example.superheroes.antiHero.entities.AntiHeroEntity;
import com.example.superheroes.antiHero.repositories.AntiHeroRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AntiHeroServiceTest {

  @Mock
  private AntiHeroRepository antiHeroRepository;

  private AntiHeroService underTest;

  @BeforeEach
  void setUp() {
    underTest = new AntiHeroService(antiHeroRepository);
  }

  @Test
  void canFindAllAntiHeroes() {
    // when
    underTest.findAllAntiHeroes();
    // then
    verify(antiHeroRepository).findAll();
  }

  @Test
  void canAddAntiHero() {
    // given
    AntiHeroEntity antiHero = new AntiHeroEntity(
      UUID.randomUUID(),
      "Bunao",
      "Lakandula",
      "Tondo",
      "Datu of Tondo",
      new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date())
    );

    // when
    underTest.addAntiHero(antiHero);

    // then
    ArgumentCaptor<AntiHeroEntity> antiHeroDtoArgumentCaptor = ArgumentCaptor.forClass(
      AntiHeroEntity.class
    );
    verify(antiHeroRepository).save(antiHeroDtoArgumentCaptor.capture());
    AntiHeroEntity capturedAntiHero = antiHeroDtoArgumentCaptor.getValue();

    assertThat(capturedAntiHero).isEqualTo(antiHero);
  }
}
