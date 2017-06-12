package ru.itis;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.config.AppConfig;
import ru.itis.dao.UsersDao;
import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UsersDao usersDao = context.getBean(UsersDao.class);
        List<User> userList = usersDao.findAll();
        System.out.println(userList);

        User user = userList.get(0);
        Auto auto = user.getAutos().get(0);
    }
}
