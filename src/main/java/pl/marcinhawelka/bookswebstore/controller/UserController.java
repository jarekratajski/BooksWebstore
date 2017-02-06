/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller;

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
import pl.marcinhawelka.bookswebstore.dto.UserChangePasswordDTO;
import pl.marcinhawelka.bookswebstore.dto.UserNewDTO;
import pl.marcinhawelka.bookswebstore.entity.User;
import pl.marcinhawelka.bookswebstore.service.UserService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || principal.username == #username")
    public String getUserDetails(Model model, @PathVariable("username") String username) {
        model.addAttribute("user", userService.findByUsername(username));
        return "user/details";
    }

    @GetMapping("new")
    public String getAddUserPage(Model model) {
        model.addAttribute("user", new UserNewDTO());
        return "user/add";
    }

    @PostMapping("new")
    public String addNewUser(Model model, @Valid @ModelAttribute("user") UserNewDTO userNewDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "user/add";
        }
        try {
            userService.addUser(userNewDTO);
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("error", e);
            return "user/add";
        }
        return "redirect:/home";
    }

    @GetMapping("change/password/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || principal.username == #username")
    public String getEditUserPage(Model model, @PathVariable String username) {
        model.addAttribute("password", new UserChangePasswordDTO());
        return "user/changePassword";
    }

    @PostMapping("change/password/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || principal.username == #username")
    public String changePassword(@Valid @ModelAttribute("password") UserChangePasswordDTO userChangePasswordDTO, BindingResult result, @PathVariable String username) {
        if (result.hasErrors()) {
            return "user/changePassword";
        }
        userService.changeUserPassword(userChangePasswordDTO, username);
        return "user/changePasswordSucces";
    }
    
    @GetMapping("/delete/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || principal.username == #username")
    public String deleteType(@PathVariable String username) {
        User user = userService.findByUsername(username);
        userService.deleteUser(user.getId());
        return "redirect:users/list";
    }
}
