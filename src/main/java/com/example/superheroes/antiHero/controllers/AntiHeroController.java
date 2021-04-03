package com.example.superheroes.antiHero.controllers;

import com.example.superheroes.antiHero.dtos.AntiHeroDto;
import com.example.superheroes.antiHero.entities.AntiHeroEntity;
import com.example.superheroes.antiHero.services.AntiHeroService;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/anti-heroes")
@PreAuthorize("isAuthenticated()")
public class AntiHeroController {

  private final AntiHeroService service;
  private final ModelMapper mapper;

  @GetMapping
  public List<AntiHeroDto> getAntiHeroes() {
    var antiHeroList = StreamSupport
      .stream(service.findAllAntiHeroes().spliterator(), false)
      .collect(Collectors.toList());

    return antiHeroList
      .stream()
      .map(this::convertToDto)
      .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public AntiHeroDto getAntiHeroById(@PathVariable("id") UUID id) {
    return convertToDto(service.findAntiHeroById(id));
  }

  @DeleteMapping("/{id}")
  public void deleteAntiHeroById(@PathVariable("id") UUID id) {
    service.removeAntiHeroById(id);
  }

  @PostMapping
  public AntiHeroDto postAntiHero(@Valid @RequestBody AntiHeroDto antiHeroDto)
    throws Exception {
    var entity = convertToEntity(antiHeroDto);
    var antiHero = service.addAntiHero(entity);

    return convertToDto(antiHero);
  }

  @PutMapping("/{id}")
  public void putAntiHero(
    @PathVariable("id") UUID id,
    @Valid @RequestBody AntiHeroDto antiHeroDto
  ) throws Exception {
    if (!id.equals(antiHeroDto.getId())) throw new ResponseStatusException(
      HttpStatus.BAD_REQUEST,
      "id does not match"
    );

    var antiHeroEntity = convertToEntity(antiHeroDto);
    service.updateAntiHero(id, antiHeroEntity);
  }

  private AntiHeroDto convertToDto(AntiHeroEntity entity) {
    return mapper.map(entity, AntiHeroDto.class);
  }

  private AntiHeroEntity convertToEntity(AntiHeroDto dto)
    throws ParseException {
    return mapper.map(dto, AntiHeroEntity.class);
  }
}