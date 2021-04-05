package com.example.superheroes.user.mapper;

import com.example.superheroes.user.data.UserDto;
import com.example.superheroes.user.entity.User;
import java.util.Iterator;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
  UserDto userToUserDto(User user);
  User userDtoToUser(UserDto user);
  List<UserDto> userListToUserDtoList(List<User> userList);
  List<User> userDtoListToUserList(List<UserDto> userDtoList);
  Iterable<UserDto> userIterableToUserDtoIterable(Iterable<User> userIterable);
  Iterable<User> userDtoIterableToUserIterable(
    Iterable<UserDto> userDtoIterable
  );
}
