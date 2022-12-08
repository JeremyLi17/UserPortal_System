package com.example.userportal.exception.domain;

/**
 * @author jeremy on 2022/12/8
 */
public class UsernameExistException extends Exception{
    public UsernameExistException(String message) {
        super(message);
    }
}
