package com.group.libraryapp.domain.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;
  @Column(nullable = false)
  private String name;

  public Book() {
  }

  public Book(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("잘못된 이름이 들어왔습니다");
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }
}
