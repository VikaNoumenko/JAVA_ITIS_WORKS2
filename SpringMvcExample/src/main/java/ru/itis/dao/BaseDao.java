package ru.itis.dao;

import java.util.List;

/**
 * 13.05.2017
 * BaseDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface BaseDao<T> {
    List<T> findAll();
    T find(int id);
    int save(T model);
    void update(T model);
    void delete(int id);
}
