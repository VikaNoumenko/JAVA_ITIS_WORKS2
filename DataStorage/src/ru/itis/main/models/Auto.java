package ru.itis.main.models;


public class Auto {
    private int id;
    private String model;
    private String color;
    private int milage;

    public Auto(String model, String color, int milage) {
        this.model = model;
        this.color = color;
        this.milage = milage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public String toString(){
        return this.id + " " +
                this.model + " " +
                this.color + " " +
                this.milage;
    }
}
