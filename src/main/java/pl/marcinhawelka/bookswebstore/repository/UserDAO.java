/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.marcinhawelka.bookswebstore.entity.User;

/**
 *
 * @author Matuidi
 */
@Repository
public interface UserDAO extends CrudRepository<User, Long>{
    
    public User findByUsername(String username);
    
    public User findByEmail(String email);
}