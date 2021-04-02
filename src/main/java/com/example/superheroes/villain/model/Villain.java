package com.example.superheroes.villain.model;

import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Villain {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @NotBlank
  private String firstName;

  private String lastName;
  private String house;
  private String knownAs;
}
