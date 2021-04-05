package com.example.superheroes.user.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UUID")
  private UUID id;

  private String username;
  private String email;
  private String mobileNumber;
  private byte[] PasswordHash;
  private byte[] PasswordSalt;
}
