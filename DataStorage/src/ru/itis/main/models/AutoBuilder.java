package ru.itis.main.models;

public class AutoBuilder {
    private int id;
    private String model;
    private String color;
    private double carMileage;
    private boolean used;
    private User idOwner;

    public AutoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public AutoBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public AutoBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public AutoBuilder setCarMileage(double carMileage) {
        this.carMileage = carMileage;
        return this;
    }

    public AutoBuilder setUsed(boolean used) {
        this.used = used;
        return this;
    }

    public AutoBuilder setIdOwner(User idOwner) {
        this.idOwner = idOwner;
        return this;
    }

    public Auto createAuto() {
        return new Auto(id, model, color, carMileage, used, idOwner);
    }
}