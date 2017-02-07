/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service.interfaces;

import java.util.List;
import pl.marcinhawelka.bookswebstore.dto.user.UserChangePasswordDTO;
import pl.marcinhawelka.bookswebstore.dto.user.UserEditDTO;
import pl.marcinhawelka.bookswebstore.dto.user.UserNewDTO;
import pl.marcinhawelka.bookswebstore.entity.User;

/**
 *
 * @author Matuidi
 */
public interface UserService {
      
    void addUser(UserNewDTO userNewDTO) throws Exception;

    void changeUserPassword(UserChangePasswordDTO userChangePasswordDTO, String username);
    
    void updateUser(User user);
    
    void updateUserDTO(UserEditDTO userEditDTO, Long id);

    void deleteUser(Long id);

    User findById(Long id);

    List<User> findAll();

    User findByUsername(String username);

}