/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.marcinhawelka.bookswebstore.entity.Type;
import pl.marcinhawelka.bookswebstore.service.interfaces.TypeService;

/**
 *
 * @author Matuidi
 */
@Component
public class StringIdToTypeConverter implements Converter<String, Type> {
   
    private final TypeService typeService;
    
    public StringIdToTypeConverter(TypeService typeService){
        this.typeService=typeService;
    }

    @Override
    public Type convert(String id) {
        try {
            return typeService.findOne(Long.parseLong(id));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
