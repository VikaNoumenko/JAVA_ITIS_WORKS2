package ru.itis.models;


public class Human  {
    private int id;
    private String name;
    private int age;

    public Human(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object object) {
        if (object instanceof Human) {
            Human that = (Human)object;
            return this.id == that.id &&
                    this.age == that.age &&
                    this.name.equals(that.name);
        } return false;
    }

    public String toString() {
        return this.id + " " +
                this.name + " " +
                this.age;
    }
}

