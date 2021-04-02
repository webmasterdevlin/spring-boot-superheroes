package com.example.superheroes.villain.controller;

import com.example.superheroes.villain.model.Villain;
import com.example.superheroes.villain.service.VillainService;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/villains")
public class VillainController {

  private final VillainService villainService;

  @GetMapping
  public Iterable<Villain> getVillains() {
    return villainService.findAllVillains();
  }

  @GetMapping("/{id}")
  public Villain getVillainById(@PathVariable("id") UUID id) {
    return villainService.findVillainById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteVillainById(@PathVariable("id") UUID id) {
    villainService.removeVillainById(id);
  }

  @PostMapping
  public Villain postVillain(@Valid @RequestBody Villain villain) {
    return villainService.addVillain(villain);
  }

  @PutMapping("/{id}")
  public void putVillain(
    @PathVariable("id") UUID id,
    @Valid @RequestBody Villain villain
  ) {
    villainService.updateVillain(id, villain);
  }
}
