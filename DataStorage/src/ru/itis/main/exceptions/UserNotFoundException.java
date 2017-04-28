package ru.itis.main.exceptions;

/**
 * 18.04.2017
 * UserNotFoundException
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
