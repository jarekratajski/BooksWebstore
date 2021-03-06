/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller.book;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.util.StreamUtils.BUFFER_SIZE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcinhawelka.bookswebstore.entity.Picture;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/picture/")
public class PictureController {

    @GetMapping("{picture}")
    public void download(Picture picture, HttpServletResponse response) throws IOException {

        FileInputStream inputStream = new FileInputStream("D://zdjecia/upload_"+picture.getUuidName());

        response.setContentType("image/jpeg");
        response.setContentLength(picture.getFileSize());

        String headerValue = String.format("attachment; filename=\"%s\"",
                picture.getOriginalName());
        response.setHeader("Content-Disposition", headerValue);

        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outStream.close();
    }
}
