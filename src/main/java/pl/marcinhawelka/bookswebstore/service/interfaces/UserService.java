/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service.interfaces;

import java.util.List;
import pl.marcinhawelka.bookswebstore.entity.User;

/**
 *
 * @author Matuidi
 */
public interface UserService {
      
    void addUser(User user) throws Exception;

    void updateUser(User user);

    void deleteUser(Long id);

    User findById(Long id);

    List<User> findAll();

    User findByUsername(String username);

}
