package com.group.libraryapp.repository;

import com.group.libraryapp.dto.user.response.UserResponse;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {
  private final JdbcTemplate jdbcTemplate;
  public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  public boolean isUserNotExist(JdbcTemplate jdbcTemplate, long id) {
    String sql = "SELECT * FROM user WHERE id = ?";
    return jdbcTemplate.query(sql, (rs, rowNum) -> 0, id).isEmpty();
  }
  public void updateUserName(JdbcTemplate jdbcTemplate, String name, long id) {
    String sql = "UPDATE user SET name = ? WHERE id = ?";
    jdbcTemplate.update(sql, name, id);
  }
  public void deleteUserByName(String name) {
    String sql = "DELETE FROM user WHERE name = ?";
    jdbcTemplate.update(sql, name);
  }

  public void saveUser(String name, Integer age) {
    String sql = "INSERT INTO user(name, age) VALUES(?, ?)";
    jdbcTemplate.update(sql, name, age);
  }
  public List<UserResponse> getUserResponses() {
    String sql = "SELECT * FROM user";
    return jdbcTemplate.query(sql, (rs, rowNum) -> {
      long id = rs.getLong("id");
      String name = rs.getString("name");
      int age = rs.getInt("age");
      return new UserResponse(id, name, age);
    }); }

}