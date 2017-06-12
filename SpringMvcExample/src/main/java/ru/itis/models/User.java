package ru.itis.models;

import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private int age;

    @OneToMany(mappedBy = "owner")
    private List<Auto> autos;

    public User() {
    }

    /**
     * Статический класс - реализация паттерна Builder
     */
    public static class Builder {
        // дублируем все поля обрамляющего класса
        private int id;
        private String login;
        private String password;
        private String name;
        private int age;

        // пустой конструктор
        public Builder() {

        }

        // метод принимающий на вход значение поля и возвращающий самого себя
        // но уже с заданным значением поля
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.age = builder.age;
        this.name = builder.name;
    }


    @Override
    public String toString() {
        return  id +" "
                + login +" "
                + password +" "
                + name +" "
                + age;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj !=null && obj instanceof User){
            User that = (User)obj;
            return this.id == that.id
                    && this.login.equals(that.login)
                    && this.password.equals(that.password)
                    && this.name.equals(that.name)
                    && this.age == that.age;
        } return false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
}

