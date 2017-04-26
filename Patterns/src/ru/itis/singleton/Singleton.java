package ru.itis.singleton;

/**
 * 25.04.2017
 * Singleton
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Singleton {
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {
        // инициализирующие операции
    }

    public static Singleton getInstance() {
        return instance;
    }
}
