package ru.itis.models;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private List<Auto> autos;
    private Integer age;
    private String login;
    private String password;

    public User(Integer id, String name, List<Auto> autos, Integer age, String login, String password) {
        this.id = id;
        this.name = name;
        this.autos = autos;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
