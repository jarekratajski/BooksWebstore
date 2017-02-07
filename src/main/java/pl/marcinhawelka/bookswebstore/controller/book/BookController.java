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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcinhawelka.bookswebstore.service.interfaces.BookService;
import pl.marcinhawelka.bookswebstore.service.interfaces.PublisherService;
import pl.marcinhawelka.bookswebstore.service.interfaces.TypeService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;
    
    @Autowired
    private TypeService typeService;
    
    private void addAllBooksInfoInModel(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("types", typeService.findAll());
    }

    @GetMapping("list")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }
    
    @GetMapping("type/{id}")
    public String listBooksByType(Model model, @PathVariable Long id){
        model.addAttribute("books", bookService.findByType(typeService.findOne(id)));
        return "book/list";
    }

    @GetMapping("{id}")
    public String detailsBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findOne(id));
        addAllBooksInfoInModel(model);
        return "/book/details";
    }
}
