package com.example.superheroes.exception;

public class CharacterNotFoundException extends RuntimeException {

  public CharacterNotFoundException(String message) {
    super(message);
  }
}
