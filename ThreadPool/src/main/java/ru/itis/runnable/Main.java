package ru.itis.runnable;

public class Main {
    public static void main(String[] args) {
        Thread newThread = new Thread(new MyThread());
        newThread.start();
    }
}
