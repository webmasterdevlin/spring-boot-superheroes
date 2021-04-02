package com.example.superheroes.villain.controller;

import com.example.superheroes.villain.model.Villain;
import com.example.superheroes.villain.service.VillainService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Api(value = "Villains", produces = "application/json", tags = "villain")
@RestController
@RequestMapping(path = "api/v1/villains")
public class VillainController {

  private final VillainService villainService;

  @GetMapping
  public List<Villain> getVillains() {
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
