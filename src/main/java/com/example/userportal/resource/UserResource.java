package com.example.userportal.resource;

import com.example.userportal.domain.User;
import com.example.userportal.exception.ExceptionHandling;
import com.example.userportal.exception.domain.EmailExistException;
import com.example.userportal.exception.domain.UserNotFoundException;
import com.example.userportal.exception.domain.UsernameExistException;
import com.example.userportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

/**
 * @author jeremy on 2022/12/5
 */
@RestController
@RequestMapping(path = {"/","/user"})
public class UserResource extends ExceptionHandling {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user)
            throws UserNotFoundException, EmailExistException, UsernameExistException {
        User newUser = userService.register(
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail());
        return new ResponseEntity<>(newUser, OK);
    }
}
