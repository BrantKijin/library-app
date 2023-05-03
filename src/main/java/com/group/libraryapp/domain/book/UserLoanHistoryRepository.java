package com.group.libraryapp.domain.book;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long > {
  boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);
  Optional<UserLoanHistory> findByUserIdAndBookName(long userId, String bookName);
}
