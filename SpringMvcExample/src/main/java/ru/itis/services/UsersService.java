package ru.itis.services;

import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.List;

/**
 * 13.05.2017
 * UsersService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    void register(User user);
    List<User> getAllUsersByAge(int age);
    List<User> getAll();
    List<User> getAllUsersByNameAndAge(String name, int age);

    List<Auto> getUserAutosByUsed(int userId, boolean isUsed);
}
