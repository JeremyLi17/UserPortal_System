package com.example.userportal.service;

import com.example.userportal.domain.User;
import com.example.userportal.exception.domain.EmailExistException;
import com.example.userportal.exception.domain.EmailNotFoundException;
import com.example.userportal.exception.domain.UserNotFoundException;
import com.example.userportal.exception.domain.UsernameExistException;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
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

    User addNewUser(String firstName,
                    String lastName,
                    String username,
                    String email,
                    String role,
                    boolean isNotLocked,
                    boolean isActive,
                    MultipartFile profileImage)
            throws UserNotFoundException, EmailExistException, UsernameExistException, IOException;

    User updateUser(String currentUsername,
                    String newFirstName,
                    String newLastName,
                    String newUsername,
                    String newEmail,
                    String role,
                    boolean isNotLocked,
                    boolean isActive,
                    MultipartFile profileImage)
            throws UserNotFoundException, EmailExistException, UsernameExistException, IOException;

    void deleteUser(Long id);

    void resetPassword(String email) throws MessagingException, EmailNotFoundException;

    User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, UsernameExistException, IOException;
}
