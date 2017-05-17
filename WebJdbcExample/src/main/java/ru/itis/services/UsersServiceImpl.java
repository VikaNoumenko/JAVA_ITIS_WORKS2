package ru.itis.services;

import ru.itis.dao.UsersDao;
import ru.itis.models.User;

import java.util.List;

/**
 * 13.05.2017
 * UsersServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public void register(User user) {
        usersDao.save(user);
    }

    @Override
    public List<User> getAllUsersByAge(int age) {
        return usersDao.findUsersByAge(age);
    }

    @Override
    public List<User> getAll() {
        return usersDao.findAll();
    }

    @Override
    public List<User> getAllUsersByNameAndAge(String name, int age) {
        return usersDao.findUsersByNameAndAge(name, age);
    }
}
