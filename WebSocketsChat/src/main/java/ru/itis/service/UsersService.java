package ru.itis.service;

import ru.itis.dto.UserDataForRegistrationDto;
import ru.itis.dto.UserDto;
import ru.itis.model.User;

import java.util.List;

public interface UsersService {
    UserDto registerUser(UserDataForRegistrationDto user);
    String login(String password, String login);
    List<User> getUsers();
}
