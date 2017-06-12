package ru.itis.dto;

public class AutoDto {
    private int id;
    private String model;
    private String color;
    private double carMileage;
    private boolean isUsed;

    public AutoDto(int id, String model, String color, double carMileage, boolean isUsed) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.carMileage = carMileage;
        this.isUsed = isUsed;
    }

    public AutoDto() {
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

    public double getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(double carMileage) {
        this.carMileage = carMileage;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
