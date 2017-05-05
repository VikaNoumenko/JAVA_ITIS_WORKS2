package ru.itis.main.models;

public class Auto implements Model{
    private int id;
    private String model;
    private String color;
    private double carMileage;
    private boolean used;
    private int owner;

    private Auto(Builder builder) {
        this.id = builder.id;
        this.model = builder.model;
        this.color = builder.color;
        this.carMileage = builder.carMileage;
        this.used = builder.used;
        this.owner = builder.owner;
    }

    public static class Builder{
        private int id;
        private String model;
        private String color;
        private double carMileage;
        private boolean used;
        private int owner;

        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder model(String model){
            this.model = model;
            return this;
        }
        public Builder color(String color){
            this.color = color;
            return this;
        }
        public Builder carMileage(Double carMileage){
            this.carMileage = carMileage;
            return this;
        }
        public Builder used(Boolean used){
            this.used = used;
            return this;
        }
        public Builder idOwner(int owner){
            this.owner = owner;
            return this;
        }
        public Auto build(){
            return new Auto(this);
        }

    }

    public int getOwner() {
        return owner;
    }

    public boolean isUsed() {
        return used;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return id+" "+model+" "+color+" "+carMileage+" "+used+" "+owner;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Auto){
            Auto that = (Auto)obj;
            if(this == that) {return true;}
            return this.id == that.id
                    && this.model.equals(that.model)
                    && this.color.equals(that.color)
                    && this.carMileage == that.carMileage
                    && this.used == that.used
                    && this.owner == that.owner;
        }return false;
    }
}