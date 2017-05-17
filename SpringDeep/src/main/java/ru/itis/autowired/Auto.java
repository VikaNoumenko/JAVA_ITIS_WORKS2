package ru.itis.autowired;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 16.05.2017
 * Auto
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Auto {
    @Autowired
    private Motor motor;

    public Auto() {
    }

    public Auto(Motor motor) {
        this.motor = motor;
    }

    public void run() {
        System.out.println("AUTO RUN");
        motor.start();
    }
}
