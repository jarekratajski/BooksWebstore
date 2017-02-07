/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service.interfaces;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import pl.marcinhawelka.bookswebstore.entity.Picture;

/**
 *
 * @author Matuidi
 */
public interface PictureService {

    Picture addPicture(MultipartFile uploadFile);

    Picture updatePicture(Picture picture, MultipartFile uploadFile);

    void deletePicture(Long id);

    Picture findOne(Long id);
    
    Picture findByUuidName(String uuidName);
    
    List<Picture> findAll();

}
