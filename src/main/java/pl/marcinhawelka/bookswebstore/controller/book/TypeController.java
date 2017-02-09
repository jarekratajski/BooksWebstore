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
import pl.marcinhawelka.bookswebstore.entity.Type;
import pl.marcinhawelka.bookswebstore.service.interfaces.BookService;
import pl.marcinhawelka.bookswebstore.service.interfaces.TypeService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/type/")
public class TypeController {

    @Autowired
    private TypeService typeService;
    
    @Autowired
    private BookService bookService;

    @GetMapping("list")
    public String listType(Model model) {
        model.addAttribute("types", typeService.findAll());
        return "type/list";
    }
}
