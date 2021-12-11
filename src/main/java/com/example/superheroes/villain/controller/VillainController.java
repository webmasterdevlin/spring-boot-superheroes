package com.example.superheroes.villain.controller;

import com.example.superheroes.villain.model.Villain;
import com.example.superheroes.villain.service.VillainService;

import java.util.UUID;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/villains")
@PreAuthorize("permitAll()")
public class VillainController {

    private VillainService villainService;

    @GetMapping
    public Iterable<Villain> getVillains() {
        return villainService.findAllVillains();
    }

    @GetMapping("/{id}")
    public Villain getVillainById(@PathVariable("id") UUID id) {
        return villainService.findVillainById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVillainById(@PathVariable("id") UUID id) {
        villainService.removeVillainById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Villain postVillain(@Valid @RequestBody Villain villain) {
        return villainService.addVillain(villain);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putVillain(
            @PathVariable("id") UUID id,
            @Valid @RequestBody Villain villain
    ) {
        villainService.updateVillain(id, villain);
    }
}
