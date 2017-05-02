package ru.itis.main.dao;

import ru.itis.main.models.Model;

import java.util.List;

/**
 * 27.04.2017
 * BaseCrudDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface BaseCrudDao<T extends Model> {
    T find(int id);
    int save(T model);
    void delete(int id);
    void update(T model);

    List<T> findAll();
}
