package ru.itis.main;

import ru.itis.main.context.AppContext;
import ru.itis.main.dao.jdbc.AutoDao;
import ru.itis.main.dao.jdbc.UsersDao;
import ru.itis.main.models.User;
import ru.itis.main.services.UsersService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AppContext context = new AppContext();
        AutoDao autoDao = context.getComponent(AutoDao.class);

    }
}
