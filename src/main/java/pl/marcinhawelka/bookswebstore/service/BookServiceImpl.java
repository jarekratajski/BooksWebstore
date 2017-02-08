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
import pl.marcinhawelka.bookswebstore.entity.Book;
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
    public void add(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void update(Book book) {
        bookDAO.save(book);
    }
    
    @Override
    public void updateQuantity(Book book){
        bookDAO.save(book);
    }

    @Override
    public void delete(Long id) {
        bookDAO.delete(id);
    }

    @Override
    public Book findOne(Long id) {
        return bookDAO.findOne(id);
    }

    @Override
    public List<Book> findAll() {
        return  bookDAO.findAll();
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
    public List<Book> findForBooksBar() {
        return bookDAO.findRandomBook();
    }

}
