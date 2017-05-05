package ru.itis.main.services;


import ru.itis.main.dao.jdbc.UsersDao;
import ru.itis.main.models.User;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void register(User user) {
        usersDao.save(user);
    }

    public boolean isRegistered(String userName) {
        List<User> users = usersDao.findAll();

        for (int i = 0; i < users.size(); i++) {
            // смотрим i-го пользователя и проверяем совпало или нет
            if (users.get(i).getName().equals(userName)) {
                return true;
            }
        }

        return false;
    }
}
