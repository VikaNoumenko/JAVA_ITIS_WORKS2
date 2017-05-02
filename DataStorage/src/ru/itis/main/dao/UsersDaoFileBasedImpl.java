package ru.itis.main.dao;

import ru.itis.main.exceptions.UserNotFoundException;
import ru.itis.main.mappers.RowMapper;
import ru.itis.main.models.User;
import ru.itis.main.utils.FileDaoQueryTemplate;

import java.util.List;

public class UsersDaoFileBasedImpl implements UsersDao {

    // поле, в котором хранится имя файла
    // в котором содежатся данные о пользователях
    private String fileName;
    private FileDaoQueryTemplate template;

    public UsersDaoFileBasedImpl(String fileName, FileDaoQueryTemplate template) {
        this.fileName = fileName;
        this.template = template;
    }

    // userRowMapper - объектная переменная
    // содержащая анонимный класс
    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(String row) {
            String rowAsArray[] = row.split(" ");
            User founded = new User(
                    Integer.parseInt(rowAsArray[0]),
                    rowAsArray[1],
                    rowAsArray[2],
                    rowAsArray[3],
                    Integer.parseInt(rowAsArray[4]));
            return founded;
        }
    };

    public int save(User user) {
        return template.save(fileName, user);
    }

    // поиск объекта по id
    public User find(int id) {
        // делаем запрос - найти в файле с именем fileName
        // используя userRowMapper человека, у которого в 0-м
        // столбце стоит id
        List<User> users =  template.findByValue(fileName,
                userRowMapper, 0, id);

        if (users.size() == 0) {
            throw new UserNotFoundException("User with id <" + id + "> not found");
        } else {
            return users.get(0);
        }
    }

    public List<User> findAll() {
        return template.findAll(fileName, userRowMapper);
    }

    public void delete(int id) {
        template.deleteByValue(fileName, 0, id);
    }

    public void update(User user) {
        template.update(fileName, user);
    }

    public List<User> findAllByName(String name) {
        return template.findByValue(fileName,
                userRowMapper, 3, name);
    }

    public List<User> findAllByAge(int age) {
        return template.findByValue(fileName,
                userRowMapper, 4, age);
    }
}