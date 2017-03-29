package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link net.proselyte.springsecurityapp.model.User} class
 * Implements {@link Validator} interface.
 *
 * @author Zolotar Sergii
 * @version 1.0
 */

@Component
public class UserValidator  implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");

        if(user.getUsername().length() < 8 || user.getUsername().length() > 32){
            errors.rejectValue("username", "Size.loginForm.username");
        }

        if(userService.findByUsename(user.getUsername())!=null){
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if(user.getPassword().length() < 8 || user.getPassword().length() > 32){
            errors.rejectValue("password", "Size.userForm.password");
        }

        if(!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
    }
}
