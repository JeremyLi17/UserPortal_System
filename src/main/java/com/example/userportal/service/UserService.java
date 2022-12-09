package com.example.userportal.service;

import com.example.userportal.domain.User;
import com.example.userportal.exception.domain.EmailExistException;
import com.example.userportal.exception.domain.UserNotFoundException;
import com.example.userportal.exception.domain.UsernameExistException;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author jeremy on 2022/12/6
 */
public interface UserService {

    User register(String firstName, String lastName, String username, String email)
            throws UserNotFoundException, EmailExistException, UsernameExistException, MessagingException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
