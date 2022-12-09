package com.example.userportal.resource;

import com.example.userportal.domain.User;
import com.example.userportal.domain.UserPrincipal;
import com.example.userportal.exception.ExceptionHandling;
import com.example.userportal.exception.domain.EmailExistException;
import com.example.userportal.exception.domain.UserNotFoundException;
import com.example.userportal.exception.domain.UsernameExistException;
import com.example.userportal.service.UserService;
import com.example.userportal.utility.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

import static com.example.userportal.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.*;

/**
 * @author jeremy on 2022/12/5
 */
@RestController
@RequestMapping(path = {"/","/user"})
public class UserResource extends ExceptionHandling {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;

    @Autowired
    public UserResource(UserService userService,
                        AuthenticationManager authenticationManager,
                        JWTProvider jwtProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        authenticate(user.getUsername(),user.getPassword());
        User loginUser = userService.findUserByUsername(user.getUsername());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return new ResponseEntity<>(loginUser, jwtHeader, OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user)
            throws UserNotFoundException, EmailExistException, UsernameExistException, MessagingException {
        User newUser = userService.register(
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail());
        return new ResponseEntity<>(newUser, OK);
    }

    private HttpHeaders getJwtHeader(UserPrincipal user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtProvider.generateJwtToken(user));
        return headers;
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
    }
}
