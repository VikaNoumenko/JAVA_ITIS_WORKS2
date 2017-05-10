package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.dao.UsersDaoJdbcImpl;
import ru.itis.model.User;

import java.util.List;

/**
 * 06.05.2017
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis\\context.xml");

        UsersDaoJdbcImpl usersDao = context.getBean(UsersDaoJdbcImpl.class);

        List<User> userList = usersDao.findUsersByAge(24);

        System.out.println(userList);
    }
}
