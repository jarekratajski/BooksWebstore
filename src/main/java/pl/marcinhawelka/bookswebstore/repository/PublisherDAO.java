/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.marcinhawelka.bookswebstore.entity.Publisher;

/**
 *
 * @author Matuidi
 */
@Repository
public interface PublisherDAO extends CrudRepository<Publisher, Long>{
    
    @Override
    List<Publisher> findAll();
}
