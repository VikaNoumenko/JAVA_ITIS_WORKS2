package ru.itis.best.thread.safe;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Singleton singleton = Singleton.getInstance();
    }
}
