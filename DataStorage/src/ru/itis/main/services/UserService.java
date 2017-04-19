package ru.itis.main.services;

import ru.itis.main.models.User;
import ru.itis.main.storages.UsersDataStorage;

import java.util.List;

public class UserService {

    private UsersDataStorage usersDataStorage;

    public UserService(UsersDataStorage usersDataStorage) {
        this.usersDataStorage = usersDataStorage;
    }

    public void register(User user) {
        usersDataStorage.save(user);
    }

    public boolean isRegistered(String userName) {
        // вытащили всех пользователей
        List<User> users = usersDataStorage.findAll();

        for (int i = 0; i < users.size(); i++) {
            // смотрим i-го пользователя и проверяем совпало или нет
            if (users.get(i).getName().equals(userName)) {
                return true;
            }
        }

        return false;
    }

}
