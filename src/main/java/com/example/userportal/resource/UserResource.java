package com.example.userportal.resource;

import com.example.userportal.exception.ExceptionHandling;
import com.example.userportal.exception.domain.EmailExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeremy on 2022/12/5
 */
@RestController
@RequestMapping(path = {"/","/api/user"})
public class UserResource extends ExceptionHandling {

    @GetMapping("/home")
    public String showUser() throws EmailExistException {
        return "works";
    }
}
