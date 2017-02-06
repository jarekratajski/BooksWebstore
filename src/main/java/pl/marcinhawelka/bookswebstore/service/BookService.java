/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import java.util.List;
import pl.marcinhawelka.bookswebstore.dto.BookDTO;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.entity.Picture;
import pl.marcinhawelka.bookswebstore.entity.Publisher;
import pl.marcinhawelka.bookswebstore.entity.Type;
/**
 *
 * @author Matuidi
 */
public interface BookService {
    
    void addBook(BookDTO bookDTO, Picture picturea);
    
    void updateBook(BookDTO bookDTO, Picture picture);
    
    void updateQuantity(Book book);
    
    void deleteBook(Long id);
    
    Book findOne(Long id);
    
    List<Book> findAll();
    
    List<Book> findAllByPublisher(Publisher publisher);
    
    List<Book> findByType(Type type);
    
    List<Book> findBooksForBooksBar();
    
}
