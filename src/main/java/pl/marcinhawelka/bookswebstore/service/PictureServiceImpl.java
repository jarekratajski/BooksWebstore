/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.marcinhawelka.bookswebstore.entity.Picture;
import pl.marcinhawelka.bookswebstore.repository.PictureDAO;

/**
 *
 * @author Matuidi
 */
@Service("PictureService")
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDAO pictureDAO;

    @Override
    public Picture addPicture(MultipartFile uploadFile) {
       if (!uploadFile.isEmpty()) {
            try {
                UUID uuid = UUID.randomUUID();
                String filename = "D://zdjecia/upload_" + uuid.toString();
                byte[] bytes = uploadFile.getBytes();
                File fsFile = new File(filename);
                fsFile.createNewFile();
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fsFile))) {
                    stream.write(bytes);
                }    
                Picture picture = new Picture();
                picture.setOriginalName(uploadFile.getOriginalFilename());
                picture.setUuidName(uuid.toString());
                picture.setFileType(uploadFile.getContentType());
                picture.setFileSize((int)uploadFile.getSize());
                pictureDAO.save(picture);
                return pictureDAO.findByUuidName(uuid.toString());
            } catch (IOException e) {
                System.out.println("File has not been uploaded" + e);
            }
        } else {
           System.out.println("Uploaded file is empty");
        }
       return null;
    }

    @Override
    public Picture updatePicture(Picture picture, MultipartFile uploadFile) {
        if (!uploadFile.isEmpty()) {
            try {
                UUID uuid = UUID.randomUUID();
                String filename = "D://zdjecia/upload_" + uuid.toString();
                byte[] bytes = uploadFile.getBytes();
                File fsFile = new File(filename);
                fsFile.createNewFile();
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fsFile))) {
                    stream.write(bytes);
                }    
                Picture p = pictureDAO.findOne(picture.getId());
                p.setOriginalName(uploadFile.getOriginalFilename());
                p.setUuidName(uuid.toString());
                p.setFileType(uploadFile.getContentType());
                p.setFileSize((int)uploadFile.getSize());
                pictureDAO.save(picture);
                return pictureDAO.findByUuidName(uuid.toString());
            } catch (IOException e) {
                System.out.println("File has not been uploaded" + e);
            }
        } else {
           System.out.println("Uploaded file is empty");
        }
       return null;
    }

    @Override
    public void deletePicture(Long id) {
        pictureDAO.delete(id);
    }

    @Override
    public Picture findOne(Long id) {
        return pictureDAO.findOne(id);
    }

    @Override
    public Picture findByUuidName(String uuidName){
        return pictureDAO.findByUuidName(uuidName);
    }
    @Override
    public List<Picture> findAll() {
        return (List<Picture>) pictureDAO.findAll();
    }

}
