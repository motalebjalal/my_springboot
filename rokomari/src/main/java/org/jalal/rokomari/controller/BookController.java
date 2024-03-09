package org.jalal.rokomari.controller;

import org.jalal.rokomari.dto.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    List<Book> bookList = new ArrayList<>();
    int id = 0;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        book.setId(++id);
        bookList.add(book);
        return book;
    }

    @GetMapping("/retrieve")
    public List<Book> getAllBook() {
        System.out.println();
        return bookList;
    }

    @GetMapping("/findById/{id}")
    public Book getBook(@PathVariable int id, Book book) {
        for (Book oneBook : bookList) {
            if (oneBook.getId() == id) {
                book = oneBook;
                break;
            }
        }
        return book;
    }


    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        System.out.println("Check for update data from postman request body : " + book.getName());
        int index = 0;
        for (Book oneBook : bookList) {
            if (oneBook.getId() == id) {
                bookList.set(index, book);
                System.out.println("After updated result : " + book.getName());
                break;
            }
            index++;
        }
        return book;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        int index = 0;
        for (Book oneBook : bookList) {
            if (oneBook.getId() == id) {
                bookList.remove(index);
                System.out.println("Deleted :" + id);
                break;
            }
            index++;
        }
    }
}
