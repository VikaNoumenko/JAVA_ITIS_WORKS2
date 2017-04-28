package ru.itis.main.dao;

import ru.itis.main.models.User;

import java.util.List;

/**
 * 27.04.2017
 * UsersDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersDao extends BaseCrudDao<User> {
    List<User> findAllByAge(int age);
    List<User> findAllByName(String name);
}
