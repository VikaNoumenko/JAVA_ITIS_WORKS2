package ru.itis;

import ru.itis.dao.UsersDaoHibernateImpl;
import ru.itis.models.Auto;
import ru.itis.models.Child;
import ru.itis.models.User;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        UsersDaoHibernateImpl usersDao = new UsersDaoHibernateImpl();
        List<User> users = usersDao.findByName("Марсель");

        User user = users.get(0);
        Child child = new Child("МиниМарсель МиниМидиков", user);
        usersDao.saveChild(child);
        int i = 0;
    }
}
