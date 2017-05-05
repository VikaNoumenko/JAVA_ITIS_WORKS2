package ru.itis.main.models;

import java.util.List;
import java.util.Objects;

public class User implements Model {

    private int id;
    private String login;
    private String password;
    private String name;
    private int age;
    private List<Auto> autos;

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
        private List<Auto> autos;

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

        public Builder autos(List<Auto> autos) {
            this.autos = autos;
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
        this.autos = builder.autos;
    }


    @Override
    public String toString() {
        return  id +" "
                + login +" "
                + password +" "
                + name +" "
                + age;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
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

    public List<Auto> getAutos() {
        return autos;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj !=null && obj instanceof User){
            User that = (User)obj;
            return this.id == that.id
                    && this.login.equals(that.login)
                    && this.password.equals(that.password)
                    && this.name.equals(that.name)
                    && this.age == that.age
                    && this.autos.equals(that.autos);
        } return false;
    }


    public int hashCode() {
        return Objects.hash(this.id, this.age, this.name, this.login, this.password);
    }
}

