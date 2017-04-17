package ru.itis.main.services;

import ru.itis.main.models.User;
import ru.itis.main.storages.UsersDataStorage;

public class UserService {

    private UsersDataStorage usersDataStorage;

    public UserService(UsersDataStorage usersDataStorage) {
        this.usersDataStorage = usersDataStorage;
    }

    public void register(User user) {
        usersDataStorage.save(user);
    }
}
