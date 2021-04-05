package com.example.superheroes.user.data;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

  private UUID id;

  private String username;
  private String email;
  private String mobileNumber;
  private String password;
}
