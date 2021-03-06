/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller.dealer;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.marcinhawelka.bookswebstore.dto.PublisherDTO;
import pl.marcinhawelka.bookswebstore.entity.Picture;
import pl.marcinhawelka.bookswebstore.entity.Publisher;
import pl.marcinhawelka.bookswebstore.service.interfaces.PictureService;
import pl.marcinhawelka.bookswebstore.service.interfaces.PublisherService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/dealer/publishers")
@PreAuthorize("hasAnyRole('ROLE_DEALER','ROLE_ADMIN')")
public class DealerPublisherController {

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private PictureService pictureService;

    @GetMapping("new")
    public String getAddPublisherPage(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/add";
    }

    @PostMapping("new")
    public String addPublisher(@RequestParam("uploadFile") MultipartFile uploadFile, @Valid @ModelAttribute("publisher") PublisherDTO publisherDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "publisher/add";
        }
        Picture picture = pictureService.addPicture(uploadFile);
        if (picture == null) {
            picture = pictureService.findByUuidName("default_publisher_logo");
        }
        publisherService.addPublisher(publisherDTO, picture);
        return "redirect:/publisher/list";
    }

    @GetMapping("edit/{publisher}")
    public String getEditPublisherPage(Model model,  Publisher publisher) {
        model.addAttribute("publisher", publisher);
        return "publisher/add";
    }

    @PostMapping("edit/{publisher}")
    public String editPublisher(@RequestParam("uploadFile") MultipartFile uploadFile, @Valid @ModelAttribute("publisher") PublisherDTO publisherDTO, BindingResult result) {

        if (result.hasErrors()) {
            return "publisher/add";
        }
        Picture picture = pictureService.addPicture(uploadFile);
        if (picture == null) {
            picture = pictureService.findByUuidName("default_publisher_logo");
        }
        publisherService.updatePublisher(publisherDTO, picture);
        return "redirect:/publisher/list";
    }

    @GetMapping("/delete/{publisher}")
    public String deletePublisher(Publisher publisher) {
        try{
        publisherService.delete(publisher);
        }catch(IllegalArgumentException e){
            e.printStackTrace(System.out);
        }
        return "redirect:/publisher/list";
    }
}
