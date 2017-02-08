/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.marcinhawelka.bookswebstore.entity.Picture;
import pl.marcinhawelka.bookswebstore.service.interfaces.PictureService;

/**
 *
 * @author Matuidi
 */
@Component
public class StringIdToPictureConverter implements Converter<String, Picture> {
   
    private final PictureService pictureService;
    
    public StringIdToPictureConverter(PictureService pictureService){
        this.pictureService=pictureService;
    }

    @Override
    public Picture convert(String id) {
        try {
            return pictureService.findOne(Long.parseLong(id));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
