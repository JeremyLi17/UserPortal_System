package com.example.userportal.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeremy on 2022/12/5
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserResource {

    @GetMapping("/home")
    public String showUser() {
        return "works";
    }
}
