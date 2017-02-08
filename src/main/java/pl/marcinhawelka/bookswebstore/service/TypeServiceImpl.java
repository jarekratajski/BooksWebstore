/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import pl.marcinhawelka.bookswebstore.service.interfaces.TypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcinhawelka.bookswebstore.dto.TypeDTO;
import pl.marcinhawelka.bookswebstore.entity.Type;
import pl.marcinhawelka.bookswebstore.repository.TypeDAO;

/**
 *
 * @author Matuidi
 */
@Service("TypeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDAO typeDAO;

    @Override
    public void addType(TypeDTO typeDTO) {
        Type t = new Type();
        t.setType(typeDTO.getType());
        typeDAO.save(t);
    }

    @Override
    public void updateType(TypeDTO typeDTO) {
        Type t = typeDAO.findOne(typeDTO.getId());
        t.setType(typeDTO.getType());
        t.setId(typeDTO.getId());
        typeDAO.save(t);
    }

    @Override
    public void deleteType(Long id) {
        typeDAO.delete(id);
    }

    @Override
    public Type findOne(Long id) {
        return typeDAO.findOne(id);
    }

    @Override
    public List<Type> findAll() {
        return typeDAO.findAll();
    }

}
