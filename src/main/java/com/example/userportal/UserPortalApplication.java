package com.example.userportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import static com.example.userportal.constant.FileConstant.USER_FOLDER;

@SpringBootApplication
public class UserPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserPortalApplication.class, args);
//        new File(USER_FOLDER).mkdir();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
