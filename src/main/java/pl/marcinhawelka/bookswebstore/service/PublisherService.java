/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import java.util.List;
import pl.marcinhawelka.bookswebstore.dto.PublisherDTO;
import pl.marcinhawelka.bookswebstore.entity.Picture;
import pl.marcinhawelka.bookswebstore.entity.Publisher;

/**
 *
 * @author Matuidi
 */
public interface PublisherService {
    
    void addPublisher(PublisherDTO publisherDTO, Picture picture);
            
    void updatePublisher(PublisherDTO publisherDTO, Picture picture);
    
    void deletePublisher(Long id);
    
    Publisher findOne(Long id);
    
    List<Publisher> findAll();
    
}
