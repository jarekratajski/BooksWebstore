/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcinhawelka.bookswebstore.service.BookService;
import pl.marcinhawelka.bookswebstore.service.TypeService;

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

    @GetMapping("{id}")
    public String getTypeById(Model model, @PathVariable Long id) {
        model.addAttribute("type", typeService.findOne(id));
        model.addAttribute("books",bookService.findByType(typeService.findOne(id)));
        return "type/details";
    }
}
