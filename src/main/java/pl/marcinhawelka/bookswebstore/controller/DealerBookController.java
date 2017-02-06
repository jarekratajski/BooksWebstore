/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.marcinhawelka.bookswebstore.dto.BookDTO;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.entity.Picture;
import pl.marcinhawelka.bookswebstore.service.BookService;
import pl.marcinhawelka.bookswebstore.service.PictureService;
import pl.marcinhawelka.bookswebstore.service.PublisherService;
import pl.marcinhawelka.bookswebstore.service.TypeService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/dealer/books")
@PreAuthorize("hasAnyRole('ROLE_DEALER','ROLE_ADMIN')")
public class DealerBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private TypeService typeService;
    
    @Autowired
    private PictureService pictureService;

    private void addAllBooksInfoInModel(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("types", typeService.findAll());
    }

    @GetMapping("new")
    public String addBook(Model model) {
        model.addAttribute("book", new BookDTO());
        addAllBooksInfoInModel(model);
        return "/book/add";

    }

    @PostMapping("new")
    public String saveBook(@RequestParam("uploadFile") MultipartFile uploadFile, Model model, @ModelAttribute("book") @Valid BookDTO bookDTO, BindingResult resoult) {

        if (resoult.hasErrors()) {
            addAllBooksInfoInModel(model);
            return "/book/add";
        }
        Picture picture = pictureService.addPicture(uploadFile);
        if(picture == null){
            picture = pictureService.findByUuidName("default_book_picture");
        }
        bookService.addBook(bookDTO , picture);
        return "redirect:/book/list";
    }

    @GetMapping("{id}")
    public String getBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findOne(id));
        addAllBooksInfoInModel(model);
        return "/book/details";
    }

    @GetMapping("edit/{id}")
    public String getEditBookPage(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findOne(id));
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("types", typeService.findAll());
        return "/book/add";
    }

    @PostMapping("edit/{id}")
    public String updateBook(@RequestParam("uploadFile") MultipartFile uploadFile, @ModelAttribute("book") @Valid BookDTO bookDTO, BindingResult resoult) {
        if (resoult.hasErrors()) {
            return "/book/add";
        }
        Picture picture = pictureService.addPicture(uploadFile);
        if(picture == null){
            picture = pictureService.findOne(bookService.findOne(bookDTO.getId()).getPicture().getId());
        }
        bookService.updateBook(bookDTO , picture);
        return "redirect:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/book/list";
    }
}
