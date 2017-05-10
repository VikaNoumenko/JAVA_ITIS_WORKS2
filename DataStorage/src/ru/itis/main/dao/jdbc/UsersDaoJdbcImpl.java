package ru.itis.main.dao.jdbc;

import ru.itis.main.models.Auto;
import ru.itis.main.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 04.05.2017
 * UsersDaoJdbcImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersDaoJdbcImpl implements UsersDao {

    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO group_user (login,password,name,age) VALUES (?,?,?,?)";
    //language=SQL
    private final String SQL_SELECT_USERS_BY_AGE = "SELECT * FROM group_user WHERE age=?";
    //language=SQL
    private final String SQL_SELECT_USERS_BY_NAME = "SELECT * FROM group_user WHERE name=?";
    //language=SQL
    private final String SQL_DELETE_USER_BY_ID= "DELETE FROM group_user WHERE id=?";
    //language=SQL
    private final String SQL_UPDATE_USER_BY_ID = "UPDATE group_user SET login=?,password=?,name=?,age=? WHERE id=?";
    // language=SQL
    private final String SQL_SELECT_ALL_USERS = "SELECT * from group_user u, auto a WHERE u.id = a.owner_id";
    //language=SQL
    private final String SQL_SELECT_ALL_USERS_WITH_JOIN = "SELECT * FROM group_user u LEFT JOIN auto a ON u.id = a.owner_id";
    //language=SQL
    private final String SQL_SELECT_USER_BY_ID = "SELECT * FROM group_user WHERE id=?";

    private Connection connection;

    public UsersDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User find(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            User user = new User.Builder()
                    .id(resultSet.getInt("id"))
                    .login(resultSet.getString("login"))
                    .password(resultSet.getString("password"))
                    .name(resultSet.getString("name"))
                    .age(resultSet.getInt("age"))
                    .build();
            return user;
        } catch (SQLException e) {
            System.err.println("SQL Exception");
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int save(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getName());
            statement.setInt(4, model.getAge());

            int addedRowsCount = statement.executeUpdate();

            if (addedRowsCount == 0) {
                throw new IllegalStateException("Problems with SQL");
            } else {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                generatedKeys.next();
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void update(User model) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_BY_ID);
            preparedStatement.setString(1,model.getLogin());
            preparedStatement.setString(2,model.getPassword());
            preparedStatement.setString(3,model.getName());
            preparedStatement.setInt(4,model.getAge());
            preparedStatement.setInt(5,model.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USERS_WITH_JOIN);
            ResultSet result = preparedStatement.executeQuery();
            Map<Integer, User> usersMap = new HashMap<>();
            while (result.next()) {
                int userId = result.getInt(1);
                if (usersMap.get(userId) == null) {
                    User user = new User.Builder()
                            .id(result.getInt(1))
                            .login(result.getString("login"))
                            .password(result.getString("password"))
                            .name(result.getString("name"))
                            .age(result.getInt("age"))
                            .autos(new ArrayList<>())
                            .build();
                    usersMap.put(user.getId(), user);
                }
                Auto auto = new Auto.Builder()
                        .id(result.getInt(6))
                        .model(result.getString("model"))
                        .color(result.getString("color"))
                        .carMileage(result.getDouble("carmileage"))
                        .used(result.getBoolean("used"))
                        .idOwner(result.getInt("owner_id"))
                        .build();
                usersMap.get(userId).getAutos().add(auto);
            }
            return new ArrayList<>(usersMap.values());
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<User> findAllByAge(int age) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USERS_BY_AGE);
            preparedStatement.setInt(1, age);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> resultUsersList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User.Builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .age(resultSet.getInt("age")).build();
                resultUsersList.add(user);
            }
            return resultUsersList;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<User> findAllByName(String name) {
        try {
            List<User> users = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USERS_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                User currentUser = new User.Builder()
                        .id(result.getInt("id"))
                        .login(result.getString("login"))
                        .password(result.getString("password"))
                        .name(result.getString("name"))
                        .age(result.getInt("age"))
                        .build();
                users.add(currentUser);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
