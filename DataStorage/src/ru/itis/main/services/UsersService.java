package ru.itis.main.services;


import ru.itis.main.models.User;

public interface UsersService {
    void register(User user);
    boolean isRegistered(String userName);
}
