package ru.itis.models;

public class Auto {
    private Integer id;
    private String model;
    private User user;
    private String color;
    private int carmileage;
    private boolean used;

    public Auto() {
    }

    public Auto(Integer id, String model, User user, String color, int carmileage, boolean used) {
        this.id = id;
        this.model = model;
        this.user = user;
        this.color = color;
        this.carmileage = carmileage;
        this.used = used;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCarmileage() {
        return carmileage;
    }

    public void setCarmileage(int carmileage) {
        this.carmileage = carmileage;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
