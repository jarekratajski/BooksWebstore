/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.marcinhawelka.bookswebstore.entity.Publisher;
import pl.marcinhawelka.bookswebstore.service.interfaces.PublisherService;

/**
 *
 * @author Matuidi
 */
@Component
public class StringIdToPublisherConverter implements Converter<String, Publisher> {
   
    private final PublisherService publisherService;
    
    public StringIdToPublisherConverter(PublisherService publisherService){
        this.publisherService=publisherService;
    }

    @Override
    public Publisher convert(String id) {
        try {
            return publisherService.findOne(Long.parseLong(id));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
