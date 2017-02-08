/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import pl.marcinhawelka.bookswebstore.service.interfaces.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcinhawelka.bookswebstore.entity.User;
import pl.marcinhawelka.bookswebstore.repository.UserDAO;

/**
 *
 * @author Matuidi
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user) throws Exception {

        if (emailExist(user.getEmail())) {
            throw new IllegalArgumentException(
                    "There is an account with that email adress: "
                    + user.getEmail());
        }
        if (usernameExist(user.getUsername())) {
            throw new Exception("There is an account with that username:" + user.getUsername());
        }
        userDAO.save(user);
    }

    private boolean emailExist(String email) {
        User user = userDAO.findByEmail(email);
        return user != null;
    }
    private boolean usernameExist(String username) {
        User user = userDAO.findByUsername(username);
        return user != null;
    }
    
    @Override
    public void updateUser(User user){
        userDAO.save(user);
    }
    
    @Override
    public void deleteUser(Long id) {
        userDAO.delete(id);
    }

    @Override
    public User findById(Long id) {
        return userDAO.findOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

}
