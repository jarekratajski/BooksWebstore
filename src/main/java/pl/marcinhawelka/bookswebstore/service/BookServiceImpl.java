/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import pl.marcinhawelka.bookswebstore.service.interfaces.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcinhawelka.bookswebstore.dto.BookDTO;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.entity.Picture;
import pl.marcinhawelka.bookswebstore.repository.BookDAO;
import pl.marcinhawelka.bookswebstore.entity.Publisher;
import pl.marcinhawelka.bookswebstore.entity.Type;
/**
 *
 * @author Matuidi
 */
@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public void addBook(BookDTO bookDTO, Picture picture) {
        Book b = new Book();

        b.setAuthor(bookDTO.getAuthor());
        b.setPrice(bookDTO.getPrice());
        b.setPublisher(bookDTO.getPublisher());
        b.setQuantity(Integer.parseInt(bookDTO.getQuantity()));
        b.setTitle(bookDTO.getTitle());
        b.setType(bookDTO.getType());
        b.setYear(bookDTO.getYear());
        b.setPicture(picture);
        
        bookDAO.save(b);
    }

    @Override
    public void updateBook(BookDTO bookDTO, Picture picture) {
        Book b = bookDAO.findOne(bookDTO.getId());

        b.setAuthor(bookDTO.getAuthor());
        b.setPrice(bookDTO.getPrice());
        b.setPublisher(bookDTO.getPublisher());
        b.setQuantity(Integer.parseInt(bookDTO.getQuantity()));
        b.setTitle(bookDTO.getTitle());
        b.setType(bookDTO.getType());
        b.setYear(bookDTO.getYear());
        b.setPicture(picture);

        bookDAO.save(b);
    }
    
    @Override
    public void updateQuantity(Book book){}

    @Override
    public void deleteBook(Long id) {
        bookDAO.delete(id);
    }

    @Override
    public Book findOne(Long id) {
        return bookDAO.findOne(id);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookDAO.findAll();
    }

    @Override
    public List<Book> findAllByPublisher(Publisher publisher) {
        return bookDAO.findByPublisher(publisher);
    }

    @Override
    public List<Book> findByType(Type type) {
        return bookDAO.findByType(type);
    }

    @Override
    public List<Book> findBooksForBooksBar() {
        return bookDAO.findRandomBook();
    }

}
