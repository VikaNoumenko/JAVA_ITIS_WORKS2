package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import ru.itis.dao.UsersDaoJdbcImpl;
import ru.itis.models.User;
import ru.itis.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 11.05.2017
 * UsersServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        super.init();
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.addActiveProfile("dev");
        context.load("ru.itis\\context.xml");
        context.refresh();
        usersService = context.getBean(UsersService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // в запрос кладу атрибут users, который из себя представляет список людей
        String userAge = request.getParameter("age");
        String userName = request.getParameter("name");

        if (userAge != null && userName != null) {
            int userAgeAsInt = Integer.parseInt(userAge);
            request.setAttribute("users", usersService.getAllUsersByNameAndAge(userName, userAgeAsInt));
        } else if (userAge != null && userName == null) {
            int userAgeAsInt = Integer.parseInt(userAge);
            request.setAttribute("users", usersService.getAllUsersByAge(userAgeAsInt));
        } else {
            request.setAttribute("users", usersService.getAll());
        }

        // я пераправляю запрос на jsp-страницу
        request.getRequestDispatcher("/jsp/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));

        User newUser = new User.Builder()
                .name(name)
                .login(login)
                .password(password)
                .age(age)
                .build();

        usersService.register(newUser);
    }
}
