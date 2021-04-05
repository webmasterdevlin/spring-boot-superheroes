package com.example.superheroes.user.data;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private UUID id;

  private String email;
  private String mobileNumber;
  private String password;
}
