/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import java.util.List;
import pl.marcinhawelka.bookswebstore.dto.TypeDTO;
import pl.marcinhawelka.bookswebstore.entity.Type;

/**
 *
 * @author Matuidi
 */
public interface TypeService {
    
    void addType(TypeDTO typeDTO);
    
    void updateType(TypeDTO typeDTO);
    
    void deleteType(Long id);
    
    Type findOne(Long id);
    
    List<Type> findAll();
}
