/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller.dealer;

import javax.validation.Valid;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
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
import pl.marcinhawelka.bookswebstore.service.interfaces.BookService;
import pl.marcinhawelka.bookswebstore.service.interfaces.PictureService;
import pl.marcinhawelka.bookswebstore.service.interfaces.PublisherService;
import pl.marcinhawelka.bookswebstore.service.interfaces.TypeService;

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

    private final  MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
 
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
        mapperFactory.classMap(Book.class, BookDTO.class);
        MapperFacade mapper  = mapperFactory.getMapperFacade();
        Book book = mapper.map(bookDTO, Book.class);
        book.setPicture(picture);
        bookService.add(book);
        return "redirect:/book/list";
    }

    @GetMapping("{id}")
    public String getBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findOne(id));
        addAllBooksInfoInModel(model);
        return "/book/details";
    }

    @GetMapping("edit/{book}")
    public String getEditBookPage(Model model, Book book) {
        model.addAttribute("book", book);
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("types", typeService.findAll());
        return "/book/add";
    }

    @PostMapping("edit/{book}")
    public String updateBook(Book book,@RequestParam("uploadFile") MultipartFile uploadFile, @ModelAttribute("book") @Valid BookDTO bookDTO, BindingResult resoult) {
        if (resoult.hasErrors()) {
            return "/book/add";
        }
        Picture picture = pictureService.addPicture(uploadFile);
        if(picture == null){
            picture = pictureService.findOne(book.getPicture().getId());
        }
        mapperFactory.classMap(Book.class, BookDTO.class);
        MapperFacade mapper  = mapperFactory.getMapperFacade();
        Book bookEntity = mapper.map(bookDTO, Book.class);
        bookEntity.setPicture(picture);
        bookService.update(bookEntity);
        return "redirect:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/book/list";
    }
}
