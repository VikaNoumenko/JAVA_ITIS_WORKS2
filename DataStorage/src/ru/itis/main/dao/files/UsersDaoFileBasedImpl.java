package ru.itis.main.dao.files;

import ru.itis.main.dao.jdbc.UsersDao;
import ru.itis.main.exceptions.UserNotFoundException;
import ru.itis.main.mappers.RowMapper;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;
import ru.itis.main.utils.FileDaoQueryTemplate;

import java.util.*;

public class UsersDaoFileBasedImpl implements UsersDao {

    private String fileName;
    private FileDaoQueryTemplate template;

    public UsersDaoFileBasedImpl(String fileName, FileDaoQueryTemplate template) {
        this.fileName = fileName;
        this.template = template;
    }

    private Map<Integer, User> usersMap;

    private RowMapper<User> userRowMapper = new RowMapper<User>(){

        @Override
        public User mapRow(String row) {
            String rowAsArray[] = row.split(" ");
            User user = new User.Builder().id(Integer.parseInt(rowAsArray[0]))
                    .login(rowAsArray[1])
                    .password(rowAsArray[2])
                    .name(rowAsArray[3])
                    .age(Integer.parseInt(rowAsArray[4]))
                    .autos(new ArrayList<Auto>()).build();
            if (usersMap != null) {
                usersMap.put(user.getId(), user);
            }
            return user;
        }
    };


    @Override
    public int save(User user) {
        return template.save(fileName,user);
    }

    // поиск объекта по id
    @Override
    public User find(int id) {

        List<User> users = template.findByValue(fileName,userRowMapper,0,id);

        if(users.size() == 0) {
            throw new UserNotFoundException("User with id <"+id+"> not found");
        } else {
            return users.get(0);
        }
    }


    @Override
    public void delete(int id) {
        template.deleteByValue(fileName,0,id);
    }

    @Override
    public void update(User model) {
        template.update(fileName,model);
    }

    @Override
    public List<User> findAll() {
        return  template.findAll(fileName,userRowMapper);
    }

    @Override
    public List<User> findAllByAge(int age) {
        return template.findByValue(fileName,userRowMapper,4,age);
    }

    @Override
    public List<User> findAllByName(String name){
        return template.findByValue(fileName,userRowMapper,3, name);
    }
}
