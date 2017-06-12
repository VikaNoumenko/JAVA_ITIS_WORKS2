package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.AutoDao;
import ru.itis.dao.UsersDao;
import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.List;

/**
 * 13.05.2017
 * UsersServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private AutoDao autoDao;

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

    @Override
    public List<Auto> getUserAutosByUsed(int userId, boolean isUsed) {
        return autoDao.findAllByUserAndByUsed(userId, isUsed);
    }
}
