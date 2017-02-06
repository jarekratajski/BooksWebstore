/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.marcinhawelka.bookswebstore.dto.UserChangePasswordDTO;
import pl.marcinhawelka.bookswebstore.dto.UserEditDTO;
import pl.marcinhawelka.bookswebstore.dto.UserNewDTO;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserNewDTO userNewDTO) throws Exception {

        if (emailExist(userNewDTO.getEmail())) {
            throw new Exception(
                    "There is an account with that email adress: "
                    + userNewDTO.getEmail());
        }
        if (usernameExist(userNewDTO.getUsername())) {
            throw new Exception("There is an account with that username:" + userNewDTO.getUsername());
        }

        User u = new User();

        u.setEmail(userNewDTO.getEmail());
        u.setEnabled(true);
        u.setOrdersAmount(0);
        u.setPassword(passwordEncoder.encode(userNewDTO.getPassword()));
        u.setRole("ROLE_USER");
        u.setUsername(userNewDTO.getUsername());

        userDAO.save(u);
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
    public void changeUserPassword(UserChangePasswordDTO userChangePasswordDTO, String username) {
        User u = userDAO.findByUsername(username);
        u.setPassword(passwordEncoder.encode(userChangePasswordDTO.getPassword()));    
        userDAO.save(u);
    }

    @Override
    public void updateUser(User user) {
        User u = userDAO.findOne(user.getId());

        u.setEmail(user.getEmail());
        u.setEnabled(user.isEnabled());
        u.setOrdersAmount(user.getOrdersAmount());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        u.setUsername(user.getUsername());
        u.setId(user.getId());

        userDAO.save(u);
    }

    @Override
    public void updateUserDTO(UserEditDTO userEditDTO, Long id){
        User u = userDAO.findOne(id);

        u.setEmail(userEditDTO.getEmail());
        u.setRole(userEditDTO.getRole());
        u.setUsername(userEditDTO.getUsername());

        userDAO.save(u);
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
        return (List<User>) userDAO.findAll();
    }

}
