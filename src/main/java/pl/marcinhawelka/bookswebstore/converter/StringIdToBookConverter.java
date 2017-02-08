/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.service.interfaces.BookService;

/**
 *
 * @author Matuidi
 */

@Component
public class StringIdToBookConverter implements Converter<String, Book> {
   
    
    private final BookService bookService;
    
    public StringIdToBookConverter(BookService bookService){
        this.bookService=bookService;
    }

    @Override
    public Book convert(String id) {
        try {
            return bookService.findOne(Long.parseLong(id));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}