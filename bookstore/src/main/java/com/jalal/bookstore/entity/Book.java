package com.jalal.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_id_seq", allocationSize = 1)
    Long id;
    String bookName;
    String title;
    String author;
    String edition;
    int pageCount;
    String country;
    String language;



}
