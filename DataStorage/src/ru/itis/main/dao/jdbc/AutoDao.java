package ru.itis.main.dao.jdbc;

import ru.itis.main.models.Auto;
import ru.itis.main.models.User;

import java.util.List;


public interface AutoDao extends BaseCrudDao<Auto>{
    List<Auto> findAllByUsed();
    List<Auto> findAllAutoByOwner(User user);

}