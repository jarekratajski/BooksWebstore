/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service.interfaces;

import java.util.List;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.entity.Publisher;
import pl.marcinhawelka.bookswebstore.entity.Type;
/**
 *
 * @author Matuidi
 */
public interface BookService {
    
    void add(Book book);
    
    void update(Book book);
    
    void updateQuantity(Book book);
    
    void delete(Long id);
    
    Book findOne(Long id);
    
    List<Book> findAll();
    
    List<Book> findAllByPublisher(Publisher publisher);
    
    List<Book> findByType(Type type);
    
    List<Book> findForBooksBar();
    
}
