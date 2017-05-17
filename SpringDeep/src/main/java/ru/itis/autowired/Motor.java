package ru.itis.autowired;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * 16.05.2017
 * Motor
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Motor {

    @Autowired
    private Cylinder cylinder;

    public Motor() {
    }

    public Motor(Cylinder cylinder) {
        this.cylinder = cylinder;
    }

    public void start() {
        System.out.println("WROOM WROOM");
        cylinder.work();
    }
}
