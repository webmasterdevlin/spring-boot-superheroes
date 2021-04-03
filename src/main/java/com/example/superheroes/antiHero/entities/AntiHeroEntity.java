package com.example.superheroes.antiHero.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table
public class AntiHeroEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
  @Column(nullable = false, updatable = false)
  private UUID id;

  @NotNull(message = "First Name is required")
  private String firstName;

  private String lastName;
  private String house;
  private String knownAs;
  private String createdAt = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z")
    .format(new Date(System.currentTimeMillis()));
}
