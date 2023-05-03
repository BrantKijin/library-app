package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.UserServiceV1;
import com.group.libraryapp.service.UserServiceV2;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


  private final UserServiceV2 userServiceV2;

  public UserController(UserServiceV2 userServiceV2) {
    this.userServiceV2 = userServiceV2;
  }

  @PostMapping("/user")
  public void saveUser(@RequestBody UserCreateRequest request) {
    userServiceV2.saveUser(request);
  }

  @GetMapping("/user")
  public List<UserResponse> getUsers() {
    return userServiceV2.getUsers();
  }


  @DeleteMapping("/user")
  public void deleteUser(@RequestParam String name) {
    userServiceV2.deleteUser(name);
  }

  @GetMapping("/user/error-test")
  public void errorTest() {
    throw new IllegalArgumentException();
  }


  @PutMapping("/user")
  public void updateUser(@RequestBody UserUpdateRequest request) {
    userServiceV2.updateUser(request);
  }

}