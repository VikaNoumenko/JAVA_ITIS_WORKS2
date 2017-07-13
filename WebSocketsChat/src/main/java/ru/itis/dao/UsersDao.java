package ru.itis.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itis.model.User;

import java.util.List;

/**
 * 25.01.17
 * UsersDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersDao extends CrudRepository<User, Integer> {
    User findByToken(String token);
    User findByLogin(String login);

    @Modifying
    @Query("update User user set user.token = ?2 where user.id = ?1")
    void updateToken(int id, String token);

    @Query("select count(user) > 0 from User user where user.token = ?1")
    boolean isExistToken(String token);
}
