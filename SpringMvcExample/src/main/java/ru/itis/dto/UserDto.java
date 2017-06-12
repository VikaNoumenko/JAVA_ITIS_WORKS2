package ru.itis.dto;

import java.util.List;

public class UserDto {
    private int id;
    private String login;
    private String password;
    private String name;
    private int age;
    private List<AutoDto> autos;

    public UserDto(int id, String login, String password, String name, int age, List<AutoDto> autos) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
        this.autos = autos;
    }

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<AutoDto> getAutos() {
        return autos;
    }

    public void setAutos(List<AutoDto> autos) {
        this.autos = autos;
    }
}
