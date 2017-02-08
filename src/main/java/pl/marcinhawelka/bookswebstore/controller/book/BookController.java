/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.entity.Type;
import pl.marcinhawelka.bookswebstore.service.interfaces.BookService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/book/")
public class BookController {

    @Autowired
    private BookService bookService;
  
    @GetMapping("list")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }
    
    @GetMapping("type/{type}")
    public String listBooksByType(Model model, Type type){
        model.addAttribute("books", bookService.findByType(type));
        return "book/list";
    }

    @GetMapping("{book}")
    public String detailsBook(Book book, Model model) {
        model.addAttribute("book", book);
        return "/book/details";
    }
}
