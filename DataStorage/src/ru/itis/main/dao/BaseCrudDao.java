package ru.itis.main.dao;

import java.util.List;

/**
 * 27.04.2017
 * BaseCrudDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface BaseCrudDao<T> {
    T find(int id);
    int save(T model);
    void delete(int id);
    void update(T model);

    List<T> findAll();
}
