package ru.itis.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.model.User;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 06.05.2017
 * ru.itis.dao.UsersDaoJdbcImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersDaoJdbcImpl {

    //language=SQL
    private final String SQL_SELECT_USERS_BY_AGE = "SELECT * FROM group_user WHERE age = ?";
    //language=SQL
    private final String SQL_SELECT_USERS_BY_NAME_AND_AGE = "SELECT * FROM group_user " +
            "WHERE name = :name AND age = :age";

    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterTemplate;

    public UsersDaoJdbcImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User.Builder()
                    .id(resultSet.getInt(1))
                    .name(resultSet.getString("name"))
                    .login(resultSet.getString("login"))
                    .password(resultSet.getString("password"))
                    .age(resultSet.getInt("age")).build();

            return user;
        }
    };

    public List<User> findUsersByAge(int age) {
        return template.query(SQL_SELECT_USERS_BY_AGE, userRowMapper, age);
    }

    public List<User> findUsersByNameAndAge(String name, int age) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("age", age);
        return namedParameterTemplate.query(SQL_SELECT_USERS_BY_NAME_AND_AGE, params, userRowMapper);
    }
}
