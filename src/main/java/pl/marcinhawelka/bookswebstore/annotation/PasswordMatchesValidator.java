/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import pl.marcinhawelka.bookswebstore.dto.user.UserNewDTO;

/**
 *
 * @author Matuidi
 */
public class PasswordMatchesValidator 
  implements ConstraintValidator<PasswordMatches, Object> { 
     
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {       
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){   
        UserNewDTO user = (UserNewDTO) obj;
        return user.getPassword().equals(user.getPasswordRepeat());    
    }     
}