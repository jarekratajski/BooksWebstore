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

/**
 *
 * @author Matuidi
 */

@Controller
@RequestMapping("/publisher")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
        
        @Autowired
        private BookService bookService;

	@GetMapping("list")
	public String showPublishers(Model model) {
		model.addAttribute("publishers", publisherService.findAll());
		return "publisher/list";
	}

	@RequestMapping("{id}")
	public String getPublishersByType(Model model, @PathVariable Long id) {
		model.addAttribute("publisher", publisherService.findOne(id));
                model.addAttribute("books", bookService.findAllByPublisher(publisherService.findOne(id)));
		return "publisher/details";
	}
}

