package com.jalal.bookstore.service;

import com.jalal.bookstore.entity.Book;

import java.util.List;

public interface BookService {

    public String addBook(Book book);
    List<Book> retrieveBook();

    Book findBook(Long id);

    Book updateBook(Book book);

    String deleteBook(Long id);

    Book searchBook(String bookName);
}
