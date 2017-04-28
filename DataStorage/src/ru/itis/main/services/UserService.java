package ru.itis.main.services;

import ru.itis.main.models.User;
import ru.itis.main.dao.UsersDaoFileBasedImpl;

import java.util.List;

public class UserService {

    private UsersDaoFileBasedImpl usersDaoFileBasedImpl;

    public UserService(UsersDaoFileBasedImpl usersDaoFileBasedImpl) {
        this.usersDaoFileBasedImpl = usersDaoFileBasedImpl;
    }

    public void register(User user) {
        usersDaoFileBasedImpl.save(user);
    }

    public boolean isRegistered(String userName) {
        // вытащили всех пользователей
        List<User> users = usersDaoFileBasedImpl.findAll();

        for (int i = 0; i < users.size(); i++) {
            // смотрим i-го пользователя и проверяем совпало или нет
            if (users.get(i).getName().equals(userName)) {
                return true;
            }
        }

        return false;
    }
}
