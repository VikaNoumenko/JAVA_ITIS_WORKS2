package ru.itis.autowired;

/**
 * 16.05.2017
 * MainPrimitive
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainPrimitive {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        Motor motor = new Motor(cylinder);
        Auto auto = new Auto(motor);

        auto.run();
    }
}
