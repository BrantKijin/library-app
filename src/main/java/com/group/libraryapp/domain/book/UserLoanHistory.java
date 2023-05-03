package com.group.libraryapp.domain.book;

import static javax.persistence.GenerationType.IDENTITY;

import com.group.libraryapp.domain.user.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserLoanHistory {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  @ManyToOne
  private User user;
  private String bookName;
  private boolean isReturn;

  public UserLoanHistory(User user, String bookName) {
    this.user = user;
    this.bookName = bookName;
    this.isReturn = false;
  }

  private UserLoanHistory() {

  }
  public void doReturn(){
    this.isReturn = true;
  }

  public String getBookName() {
    return this.bookName;
  }
}