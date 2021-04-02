package com.example.superheroes.villain.service;

import com.example.superheroes.exception.CharacterNotFoundException;
import com.example.superheroes.villain.model.Villain;
import com.example.superheroes.villain.repository.VillainRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VillainService {

  private final VillainRepository villainRepository;

  public List<Villain> findAllVillains() {
    return villainRepository.findAll();
  }

  public Villain findVillainById(UUID id) {
    return findOrThrow(id);
  }

  public void removeVillainById(UUID id) {
    villainRepository.deleteById(id);
  }

  public Villain addVillain(Villain villain) {
    return villainRepository.save(villain);
  }

  public void updateVillain(UUID id, Villain villain) {
    findOrThrow(id);
    villainRepository.save(villain);
  }

  private Villain findOrThrow(final UUID id) {
    return villainRepository
      .findById(id)
      .orElseThrow(
        () ->
          new CharacterNotFoundException(
            "Villain by id " + id + " was not found"
          )
      );
  }
}
