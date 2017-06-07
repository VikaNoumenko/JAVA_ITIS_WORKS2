package ru.itis.best.thread.safe;

public class Singleton {

    private Singleton() {
        System.out.println("In Lazy");
    }

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
