package com.example.superheroes.user.entity;

import java.util.UUID;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
  @Column(nullable = false, updatable = false)
  private UUID id;

  private String email;
  private String mobileNumber;
  private byte[] StoredHash;
  private byte[] StoredSalt;
}
