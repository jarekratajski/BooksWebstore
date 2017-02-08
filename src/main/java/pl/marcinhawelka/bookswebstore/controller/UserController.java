/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller;

import javax.validation.Valid;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcinhawelka.bookswebstore.dto.user.UserChangePasswordDTO;
import pl.marcinhawelka.bookswebstore.dto.user.UserNewDTO;
import pl.marcinhawelka.bookswebstore.entity.User;
import pl.marcinhawelka.bookswebstore.service.interfaces.UserService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
         
    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
    
    @GetMapping("{user}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || principal.username == #user.username")
    public String getUserDetails(Model model,User user) {
        model.addAttribute("user",user);
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
       
        mapperFactory.classMap(User.class, UserNewDTO.class);
        MapperFacade mapper  = mapperFactory.getMapperFacade();
        User user = mapper.map(userNewDTO, User.class);
        user.setPassword(passwordEncoder.encode(userNewDTO.getPassword()));
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        try {
            userService.addUser(user);
        } catch(IllegalArgumentException e){
            model.addAttribute("errorEmail", "Podany adress email jest juz zajety");
            return "user/add";
        }catch (Exception e) {
            model.addAttribute("errorUsername", "Podany nick jest juz zajety");
            return "user/add";
        } 
        return "redirect:/home";
    }

    @GetMapping("change/password/{user}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || principal.username == #user.username")
    public String getChangePasswordPage(Model model, User user) {
        model.addAttribute("password", new UserChangePasswordDTO());
        return "user/changePassword";
    }

    @PostMapping("change/password/{user}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || principal.username == #user.username")
    public String handleChangePasswordPage(@Valid @ModelAttribute("password") UserChangePasswordDTO userChangePasswordDTO, BindingResult result,User user) {
        if (result.hasErrors()) {
            return "user/changePassword";
        }
        user.setPassword(passwordEncoder.encode(userChangePasswordDTO.getPassword()));
        userService.updateUser(user);
        return "user/changePasswordSucces";
    }
    
    @GetMapping("/delete/{user}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || principal.username == #user.username")
    public String deleteUser(User user) {
        userService.deleteUser(user.getId());
        return "redirect:users/list";
    }
}
