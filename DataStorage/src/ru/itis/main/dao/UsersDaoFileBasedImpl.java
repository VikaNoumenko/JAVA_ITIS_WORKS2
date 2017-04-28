package ru.itis.main.dao;

import ru.itis.main.exceptions.UserNotFoundException;
import ru.itis.main.generators.SingletonIdGenerator;
import ru.itis.main.mappers.RowMapper;
import ru.itis.main.models.User;
import ru.itis.main.utils.FileDaoQueryUtils;

import java.io.*;
import java.util.List;

public class UsersDaoFileBasedImpl implements UsersDao {

    // поле, в котором хранится имя файла
    // в котором содежатся данные о пользователях
    private String fileName;
    private FileDaoQueryUtils utils;

    public UsersDaoFileBasedImpl(String fileName) {
        this.fileName = fileName;
        this.utils = new FileDaoQueryUtils();
    }

    public int save(User user) {
        try {
            // на вход принимаем можель без id
            // генерируем id
            user.setId(SingletonIdGenerator.getGenerator().generateId());
            // открываем файловый поток для дозаписи
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            // преобразуем пользователя в строку через toString
            String userDataAsString = user.toString();
            // преобразуем строку в массив байтов
            // записываем в файл
            writer.write(userDataAsString);
            writer.newLine();
            writer.close();
            return user.getId();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return -1;
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

    // поиск объекта по id
    public User find(int id) {
        // делаем запрос - найти в файле с именем fileName
        // используя userRowMapper человека, у которого в 0-м
        // столбце стоит id
        List<User> users =  utils.findByValue(fileName,
                userRowMapper, 0, id);

        if (users.size() == 0) {
            throw new UserNotFoundException("User with id <" + id + "> not found");
        } else {
            return users.get(0);
        }
    }

    public List<User> findAll() {
        return null;
    }

    public void delete(int id) {
        // получили всех пользователей
        List<User> buffer = findAll();
        // индекс удаляемого пользователя в списке
        int indexOfDeleted = -1;
        // идем по всему списку
        for (int i = 0; i < buffer.size(); i++) {
            // получаем текущего i-го пользователя
            User currentUser = buffer.get(i);
            // если id просматриваемого пользователя
            // совпал с id пользователя, которого мы хотим удалить
            if (currentUser.getId() == id) {
                // запоминаем его индекс
                indexOfDeleted = i;
                // останавливаем цикл
                break;
            }
        }
        // если мы нашли пользователя, которого надо удалить
        if (indexOfDeleted > -1) {
            // удаляем
            buffer.remove(indexOfDeleted);
        }

        flushFromBuffer(buffer);
    }

    /**
     * Обновление записи в хранилище
     * @param user новые данные пользователя. id - там уже указан
     */
    public void update(User user) {
    }

    public List<User> findAllByName(String name) {
        return utils.findByValue(fileName,
                userRowMapper, 3, name);
    }

    public List<User> findAllByAge(int age) {
        return utils.findByValue(fileName,
                userRowMapper, 4, age);
    }

    private void flushFromBuffer(List<User> buffer) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileName));

            for (int i = 0; i < buffer.size(); i++) {
                writer.write(buffer.get(i).toString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}
