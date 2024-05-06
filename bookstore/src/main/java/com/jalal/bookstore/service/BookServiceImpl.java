package com.jalal.bookstore.service;

import com.jalal.bookstore.entity.Book;
import com.jalal.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String addBook(Book book) {
        Book saveBook = bookRepository.save(book);
        return saveBook.getBookName();
    }

    @Override
    public List<Book> retrieveBook() {
        return bookRepository.findAll();

    }

    @Override
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
       return optionalBook.get();

    }

    @Override
    public Book updateBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();

            existingBook.setBookName(book.getBookName());
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setEdition(book.getEdition());
            existingBook.setPageCount(book.getPageCount());
            existingBook.setCountry(book.getCountry());
            existingBook.setLanguage(book.getLanguage());
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book not found with id: " + book.getId());
        }
    }


    @Override
    public String deleteBook(Long id) {
        Book book = bookRepository.findById(id).get();
         bookRepository.delete(book);
        return book.getBookName();
    }

    @Override
    public Book searchBook(String bookName) {
        Book bookByBookName = bookRepository.findBookByBookName(bookName);
        return bookByBookName;
    }
}
