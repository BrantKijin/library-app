package com.group.libraryapp.service;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;

import com.group.libraryapp.repository.UserJdbcRepository;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceV1 {
  private final UserJdbcRepository userRepository;
  public UserServiceV1(JdbcTemplate jdbcTemplate) {
    this.userRepository = new UserJdbcRepository(jdbcTemplate);
  }
  public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request) {
    if (userRepository.isUserNotExist(jdbcTemplate, request.getId())) {
      throw new IllegalArgumentException();
    }
    userRepository.updateUserName(jdbcTemplate, request.getName(), request.getId());
  }

  public void saveUser(UserCreateRequest request) {
    userRepository.saveUser(request.getName(), request.getAge());
  }

  public void deleteUser(String name) {
//    if (userRepository.isUserNotExist(name)) {
//      throw new IllegalArgumentException();
//    }
    userRepository.deleteUserByName(name);
  }
  public List<UserResponse> getUsers() {
    return userRepository.getUserResponses();
  }
}