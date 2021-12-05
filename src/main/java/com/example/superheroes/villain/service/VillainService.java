package com.example.superheroes.villain.service;

import com.example.superheroes.exception.NotFoundException;
import com.example.superheroes.villain.model.Villain;
import com.example.superheroes.villain.repository.VillainRepository;

import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VillainService {

    private final VillainRepository villainRepository;

    public Iterable<Villain> findAllVillains() {
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
                        () -> new NotFoundException("Villain by id " + id + " was not found")
                );
    }
}
