/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.marcinhawelka.bookswebstore.entity.User;
import pl.marcinhawelka.bookswebstore.service.interfaces.UserService;

/**
 *
 * @author Matuidi
 */
@Component
public class StringUsernameToUserConverter implements Converter<String, User> {
   
    private final UserService userService;
    
    public StringUsernameToUserConverter(UserService userService){
        this.userService=userService;
    }

    @Override
    public User convert(String username) {
        try {
            return userService.findByUsername(username);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}