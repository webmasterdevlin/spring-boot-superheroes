package com.example.superheroes.villain.model;

import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Villain")
@Data
@Entity
@Table
public class Villain {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
  @Column(nullable = false, updatable = false)
  private UUID id;

  @NotNull(message = "First Name is required")
  private String firstName;

  private String lastName;
  private String house;
  private String knownAs;
}
