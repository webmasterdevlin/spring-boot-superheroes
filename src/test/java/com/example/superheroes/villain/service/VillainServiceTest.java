package com.example.superheroes.villain.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import com.example.superheroes.villain.model.Villain;
import com.example.superheroes.villain.repository.VillainRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VillainServiceTest {

  @Mock
  private VillainRepository villainRepository;

  private VillainService underTest;

  @BeforeEach
  void setUp() {
    underTest = new VillainService(villainRepository);
  }

  @Test
  void canFindAllVillains() {
    // when
    underTest.findAllVillains();
    // then
    verify(villainRepository).findAll();
  }

  @Test
  void canAddVillain() {
    // given
    Villain villain = new Villain(
      UUID.randomUUID(),
      "Bunao",
      "Lakandula",
      "Tondo",
      "Datu of Tondo"
    );

    // when
    underTest.addVillain(villain);

    // then
    ArgumentCaptor<Villain> villainArgumentCaptor = ArgumentCaptor.forClass(
      Villain.class
    );
    verify(villainRepository).save(villainArgumentCaptor.capture());
    Villain capturedVillain = villainArgumentCaptor.getValue();

    assertThat(capturedVillain).isEqualTo(villain);
    /*
     NOTE:
     underTest.findVillainById(villain.getId());
     is not going to work because mockito only provides if methods can be called.
    */
  }
}
