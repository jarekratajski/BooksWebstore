/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import pl.marcinhawelka.bookswebstore.entity.Book;

/**
 *
 * @author Matuidi
 */
public class PublisherDTO {

    private Long id;
    
    @NotBlank
    private String name;
     
    @NotNull
    private String creationYear;
    
    private List<Book> book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(String creationYear) {
        this.creationYear = creationYear;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "PublisherDTO{" + "id=" + id + ", name=" + name + ", creationYear=" + creationYear + ", book=" + book + '}';
    }

    
}
