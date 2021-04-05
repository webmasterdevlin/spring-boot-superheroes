package com.example.superheroes.user.service;

import com.example.superheroes.exception.BadRequestException;
import com.example.superheroes.exception.NotFoundException;
import com.example.superheroes.user.data.UserDto;
import com.example.superheroes.user.entity.User;
import com.example.superheroes.user.mapper.UserMapper;
import com.example.superheroes.user.repository.UserRepository;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.SecureRandom;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

  private final UserRepository repo;

  public Iterable<UserDto> findAllUsers() {
    var userIterable = repo.findAll();
    return UserMapper.INSTANCE.userIterableToUserDtoIterable(userIterable);
  }

  public UserDto findUserById(final UUID id) {
    var user = repo
      .findById(id)
      .orElseThrow(
        () -> new NotFoundException("User by id " + id + " was not found")
      );

    return UserMapper.INSTANCE.userToUserDto(user);
  }

  public UserDto createUser(UserDto userDto, String password)
    throws NoSuchAlgorithmException {
    var user = UserMapper.INSTANCE.userDtoToUser(userDto);

    if (password.isBlank()) throw new IllegalArgumentException(
      "Password is required"
    );

    var existsEmail = repo.selectExistsEmail(user.getEmail());
    if (existsEmail) throw new BadRequestException(
      "Email " + user.getEmail() + " taken"
    );

    repo
      .findAll()
      .forEach(
        u -> {
          if (
            u.getUsername().equals(user.getUsername())
          ) throw new IllegalArgumentException(
            "Username " + user.getUsername() + " is already taken"
          );
        }
      );

    byte[] salt = createSalt();
    byte[] hashedPassword = createPasswordHash(password, salt);

    user.setPasswordSalt(salt);
    user.setPasswordHash(hashedPassword);

    repo.save(user);

    return UserMapper.INSTANCE.userToUserDto(user);
  }

  public void updateUser(UUID id, UserDto userDto, String password)
    throws NoSuchAlgorithmException {
    var user = findOrThrow(id);
    var userParam = UserMapper.INSTANCE.userDtoToUser(userDto);

    if (!userParam.getUsername().equals(user.getUsername())) {
      // username has changed so check if the new username is already taken
      repo
        .findAll()
        .forEach(
          u -> {
            if (
              u.getUsername().equals(userParam.getUsername())
            ) throw new IllegalArgumentException(
              "Username " + userParam.getUsername() + " is already taken"
            );
          }
        );
    }
    // update user properties
    user.setUsername(userParam.getUsername());
    user.setEmail(userParam.getEmail());
    user.setMobileNumber(userParam.getMobileNumber());

    if (!password.isBlank()) {
      byte[] salt = createSalt();
      byte[] hashedPassword = createPasswordHash(password, salt);

      user.setPasswordSalt(salt);
      user.setPasswordHash(hashedPassword);
    }

    repo.save(user);
  }

  public void removeUserById(UUID id) {
    findOrThrow(id);
    repo.deleteById(id);
  }

  private byte[] createSalt() {
    var random = new SecureRandom();
    var salt = new byte[16];
    random.nextBytes(salt);

    return salt;
  }

  private byte[] createPasswordHash(String password, byte[] salt)
    throws NoSuchAlgorithmException {
    var md = MessageDigest.getInstance("SHA-512");
    md.update(salt);

    return md.digest(password.getBytes(StandardCharsets.UTF_8));
  }

  private User findOrThrow(final UUID id) {
    return repo
      .findById(id)
      .orElseThrow(
        () -> new NotFoundException("User by id " + id + " was not found")
      );
  }
}
