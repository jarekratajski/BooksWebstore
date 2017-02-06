/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import pl.marcinhawelka.bookswebstore.dto.UserChangePasswordDTO;

/**
 *
 * @author Matuidi
 */
public class PasswordMatchesChangePasswordValidator 
 implements ConstraintValidator<PasswordMatchesChangePassord, Object> { 
     
    @Override
    public void initialize(PasswordMatchesChangePassord constraintAnnotation) {       
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){   
        UserChangePasswordDTO user = (UserChangePasswordDTO) obj;
        return user.getPassword().equals(user.getPasswordRepeat());    
    }     
}
