package com.jalal.bookstore.repository;

import com.jalal.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
Book findBookByBookName(String bookName);
}
