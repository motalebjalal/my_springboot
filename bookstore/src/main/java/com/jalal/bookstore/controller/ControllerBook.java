package com.jalal.bookstore.controller;

import com.jalal.bookstore.entity.Book;
import com.jalal.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RestController
@Controller
@RequestMapping("/book")
public class ControllerBook {
    private final BookService bookService;

    public ControllerBook(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("name","Rokomari");
        return "home";
    }

    @GetMapping("/form")
    public String formRoot(Model model){
        return "form";
    }

    @PostMapping("/add")
    public String saveBookRoot(Book book){
        System.out.println(book.getBookName());
        bookService.addBook(book);
        return "redirect:/book/form";
    }

    @GetMapping("/retrieve")
    public String retrieveBookRoot(Model model){
        List<Book> books = bookService.retrieveBook();
        model.addAttribute("books", books);
        return "retrieve";
    }

    @GetMapping("/find")
    public String findBookRoot(@RequestParam Long id, Model model){
        Book book = bookService.findBook(id);
        /*model.addAttribute("book",book);*/
        return "find";
    }

    @GetMapping("/edit")
    public String editRoot(@RequestParam Long id, Model model){
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit";
    }


    @PostMapping("/update")
    public String updateBookRoot(@ModelAttribute("book") Book book){
        bookService.updateBook(book);
        return "redirect:/book/retrieve";
    }


    @GetMapping("/delete")
    public String deleteRoot(@RequestParam Long id){
        bookService.deleteBook(id);
        return "redirect:/book/retrieve";
    }


    @GetMapping("/search")
    public String SearchBook(@RequestParam String bookName, Model model){
        Book book = bookService.searchBook(bookName);
        model.addAttribute("book",book);
        return "search";
    }

}
