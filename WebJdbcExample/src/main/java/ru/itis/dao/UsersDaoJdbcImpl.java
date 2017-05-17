package ru.itis.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.models.User;

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
public class UsersDaoJdbcImpl implements UsersDao {

    //language=SQL
    private final String SQL_SELECT_USERS = "SELECT * FROM group_user";
    //language=SQL
    private final String SQL_SELECT_USERS_BY_AGE = "SELECT * FROM group_user WHERE age = ?";
    //language=SQL
    private final String SQL_SELECT_USERS_BY_NAME_AND_AGE = "SELECT * FROM group_user " +
            "WHERE name = :name AND age = :age";
    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO group_user(name, age, login, password) VALUES" +
            "(:name, :age, :login, :password)";

    //language=SQL
    private final String SQL_SELECT_USER_BY_ID =
            "SELECT * FROM group_user WHERE id = ?";

    //language=SQL
    private final String SQL_DELETE_USER_BY_ID =
            "DELETE FROM group_user WHERE id = ?";

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

    @Override
    public List<User> findAll() {
        return template.query(SQL_SELECT_USERS, userRowMapper);
    }

    @Override
    public User find(int id) {
        return template.queryForObject(SQL_SELECT_USER_BY_ID, new Object[]{id}, userRowMapper);
    }

    @Override
    public int save(User model) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", model.getName());
        params.addValue("age", model.getAge());
        params.addValue("password", model.getPassword());
        params.addValue("login", model.getLogin());
        KeyHolder holder = new GeneratedKeyHolder();
        namedParameterTemplate.update(SQL_INSERT_USER, params, holder, new String[]{"id"});
        Number number = holder.getKey();
        return number.intValue();
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(int id) {
        template.update(SQL_DELETE_USER_BY_ID, id);
    }

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
