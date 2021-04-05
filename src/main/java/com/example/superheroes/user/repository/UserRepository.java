package com.example.superheroes.user.repository;

import com.example.superheroes.user.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
  @Query(
    "" +
    "SELECT CASE WHEN COUNT(u) > 0 THEN " +
    "TRUE ELSE FALSE END " +
    "FROM User u " +
    "WHERE u.email = ?1"
  )
  Boolean selectExistsEmail(String email);
}
