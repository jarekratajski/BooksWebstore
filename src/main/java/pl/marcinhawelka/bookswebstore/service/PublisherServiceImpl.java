/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import pl.marcinhawelka.bookswebstore.service.interfaces.PublisherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcinhawelka.bookswebstore.dto.PublisherDTO;
import pl.marcinhawelka.bookswebstore.entity.Picture;
import pl.marcinhawelka.bookswebstore.entity.Publisher;
import pl.marcinhawelka.bookswebstore.repository.PublisherDAO;

/**
 *
 * @author Matuidi
 */

@Service("PublisherService")
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherDAO publisherDAO;

    @Override
    public void addPublisher(PublisherDTO publisherDTO, Picture picture) {
        Publisher p = new Publisher();
        p.setCreationYear(publisherDTO.getCreationYear());
        p.setName(publisherDTO.getName());
        p.setLogo(picture);
        publisherDAO.save(p);
    }

    @Override
    public void updatePublisher(PublisherDTO publisherDTO, Picture picture) {
        Publisher p = publisherDAO.findOne(publisherDTO.getId());
        p.setCreationYear(publisherDTO.getCreationYear());
        p.setName(publisherDTO.getName());
        p.setId(publisherDTO.getId());
        p.setLogo(picture);
        publisherDAO.save(p);
    }

    @Override
    public void delete(Publisher publisher) {
        publisherDAO.delete(publisher);
    }

    @Override
    public Publisher findOne(Long id) {
       return publisherDAO.findOne(id);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherDAO.findAll();
    }

}
