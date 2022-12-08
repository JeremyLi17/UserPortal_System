package com.example.userportal.repository;

import com.example.userportal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jeremy on 2022/12/6
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
