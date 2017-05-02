package ru.itis.main.dao;

import ru.itis.main.models.Auto;

import java.util.List;

/**
 * 27.04.2017
 * AutoDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AutoDao extends BaseCrudDao<Auto> {
    List<Auto> findAllByUsed(boolean isUsed);
    List<Auto> findAllAutoByUserId(int userId);
}
