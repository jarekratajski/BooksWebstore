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
import pl.marcinhawelka.bookswebstore.dto.TypeDTO;
import pl.marcinhawelka.bookswebstore.entity.Type;
import pl.marcinhawelka.bookswebstore.service.interfaces.TypeService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/dealer/types")
@PreAuthorize("hasAnyRole('ROLE_DEALER','ROLE_ADMIN')")
public class DealerTypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("new")
    public String getAddTypePage(Model model) {
        model.addAttribute("type", new Type());
        return "type/add";
    }

    @PostMapping("new")
    public String addType(@Valid @ModelAttribute("type") TypeDTO typeDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "type/add";
        }
        typeService.addType(typeDTO);
        return "redirect:/type/list";
    }

    @GetMapping("edit/{id}")
    public String getEditTypePage(Model model, @PathVariable Long id) {
        model.addAttribute("type", typeService.findOne(id));
        return "type/add";
    }

    @PostMapping("edit/{id}")
    public String editType(@Valid @ModelAttribute("type") TypeDTO typeDTO, @PathVariable Long id, BindingResult result) {

        if (result.hasErrors()) {
            return "type/add";
        }
        typeService.updateType(typeDTO);
        return "redirect:/type/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteType(@PathVariable Long id) {
        typeService.deleteType(id);
        return "redirect:/type/list";
    }
}
