/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.service.BookService;

/**
 *
 * @author Matuidi
 */
@Controller
public class HomeController {
    
        @Autowired
        private BookService bookService;
        
        @GetMapping("/home")
        public String welcome(Model model){
            
            List<Book> books = bookService.findBooksForBooksBar();
            model.addAttribute("books", books);
            return "home";
        }
        @GetMapping("/")
        public String welcome1(Model model){
            return "redirect:home";
        }
        @GetMapping("/underconstruction")
        public String underConstruction(){
            return "underconstruction";
        }
}
