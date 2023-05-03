package com.group.libraryapp.service;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceV2 {
  private final UserRepository userRepository;

  public UserServiceV2(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void saveUser(UserCreateRequest request) {
    User user = userRepository.save(new User(request.getName(), request.getAge()));
    System.out.println(user.getId());
  }

  public List<UserResponse> getUsers() {
    return userRepository.findAll().stream()
        .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
        .collect(Collectors.toList());
  }

  public void updateUser(UserUpdateRequest request) {
    User user = userRepository.findById(request.getId())
        .orElseThrow(IllegalArgumentException::new);
    user.updateName(request.getName());
    userRepository.save(user);
  }

  public void deleteUser(String name) {
    User user = userRepository.findByName(name).get();
    if (user == null) {
      throw new IllegalArgumentException();
    }
    userRepository.delete(user);
  }
}
