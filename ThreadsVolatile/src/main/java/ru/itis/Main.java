package ru.itis;

public class Main {
    public volatile static int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }


}
