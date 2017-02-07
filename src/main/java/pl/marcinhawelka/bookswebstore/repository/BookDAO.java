/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.entity.Publisher;
import pl.marcinhawelka.bookswebstore.entity.Type;

/**
 *
 * @author Matuidi
 */
@Repository
public interface BookDAO extends CrudRepository<Book, Long> {

    List<Book> findByType(Type type);

    List<Book> findByPublisher(Publisher publisher);

    @Query("select b from Book b order by RANDOM() ")
    List<Book> findRandomBook();
}
