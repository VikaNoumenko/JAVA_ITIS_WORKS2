package ru.itis.models;

import javax.persistence.*;

@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String model;

    @Column
    private String color;

    @Column(name = "carmileage")
    private double carMileage;

    @Column(name = "used")
    private boolean isUsed;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Auto(int id, String model, String color, double carMileage, boolean used) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.carMileage = carMileage;
        this.isUsed = used;
    }

    public Auto() {
    }

    public static class Builder {
        private int id;
        private String model;
        private String color;
        private double carMileage;
        private boolean used;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setCarMileage(double carMileage) {
            this.carMileage = carMileage;
            return this;
        }

        public Builder setUsed(boolean used) {
            this.used = used;
            return this;
        }

        public Auto build() {
            return new Auto(id, model, color, carMileage, used);
        }
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getCarMileage() {
        return carMileage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCarMileage(double carMileage) {
        this.carMileage = carMileage;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean used) {
        isUsed = used;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Auto){
            Auto that = (Auto)obj;
            return this.id == that.id
                    && this.model.equals(that.model)
                    && this.color.equals(that.color)
                    && this.carMileage == that.carMileage
                    && this.isUsed == that.isUsed;
        }return false;
    }

}
