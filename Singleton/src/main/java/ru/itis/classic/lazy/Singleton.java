package ru.itis.classic.lazy;

// синглтон с ленивой инициализацией
public class Singleton {
    // instance - единственный экзмепляр
    private static volatile Singleton instance = null;

    // приватный конструктор
    private Singleton() {
    }

    // статический метод требования объекта
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
