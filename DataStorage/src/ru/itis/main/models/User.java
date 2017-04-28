package ru.itis.main.models;

public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private int age;

    public User(int id, String login, String password, String name, int age) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public User(String login, String password, String name, int age) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
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

    public String toString() {
        return this.id + " " +
                this.login + " " +
                this.password + " " +
                this.name + " " +
                this.age;
    }

    public boolean equals(Object object) {
        if (object instanceof User) {
            User that = (User)object;
            return this.id == that.id &&
                    this.age == that.age &&
                    this.name.equals(that.name) &&
                    this.login.equals(that.login) &&
                    this.password.equals(that.password);
        } return false;
    }
}
