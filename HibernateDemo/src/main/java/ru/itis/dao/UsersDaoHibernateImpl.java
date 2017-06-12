package ru.itis.dao;

import org.hibernate.Session;

import ru.itis.hibernate.HibernateConnector;
import ru.itis.models.Child;
import ru.itis.models.User;

import java.util.List;

public class UsersDaoHibernateImpl {
    private Session session;

    public UsersDaoHibernateImpl() {

    }

    public List<User> findByName(String name) {
        // открыл сессию
        this.session = HibernateConnector.getConnector().getSession();
        // начал транзакцию
        session.beginTransaction();

        List<User> result =  session.createQuery("from User user where name = :userName", User.class)
                .setParameter("userName", name).list();
        session.getTransaction().commit();

        return result;
    }

    public Integer saveChild(Child child) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();

        Integer resultId = (Integer) session.save(child);

        session.getTransaction().commit();

        return resultId;
    }
}
