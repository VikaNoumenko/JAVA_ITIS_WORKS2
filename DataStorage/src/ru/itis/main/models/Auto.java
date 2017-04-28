package ru.itis.main.models;

/**
 * 27.04.2017
 * Auto
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Auto {
    private int id;
    private String model;
    private String color;
    private int mileage;
    private boolean used;

    public Auto(String model, String color, int mileage, boolean used) {
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.used = used;
    }
    public Auto(int id, String model, String color, int mileage,boolean used) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.used = used;
    }

    public boolean isUsed() {
        return used;
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

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String toString(){
        return this.id + " " +
                this.model + " " +
                this.color + " " +
                this.mileage;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Auto){
            Auto that = (Auto)obj;
            return this.id == that.id
                    && this.model.equals(that.model)
                    && this.color.equals(that.color)
                    && this.mileage == that.mileage;
        }return false;
    }
}
